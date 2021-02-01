using BlogsApi.Entities;
using BlogsApi.Interfaces;
using Microsoft.EntityFrameworkCore;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BlogsApi.Services
{
    public class BlogService : IBlogService
    {
        private readonly BlogsDbContext blogsDbContext;
        public BlogService(BlogsDbContext blogsDbContext)
        {
            this.blogsDbContext = blogsDbContext;
        }
        public async Task<List<Blog>> GetAllBlogs()
        {
            var blogs = blogsDbContext.Blogs.Include(o => o.Categories).Where(o => o.Active).OrderByDescending(o => o.TS);
            return await blogs.ToListAsync();
        }
        public async Task<List<Blog>> GetBlogsUnderCategory(int id)
        {
            var blogs = blogsDbContext.Blogs.Include(o => o.Categories).Where(o => o.Active && o.Categories.Any(category => category.Id == id));
            return await blogs.ToListAsync();
        }
    }
}