using BlogsApi.Entities;
using BlogsApi.Interfaces;
using Microsoft.EntityFrameworkCore;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace BlogsApi.Services
{
    public class CategoryService : ICategoryService
    {
        private BlogsDbContext blogsDbContext;

        public CategoryService(BlogsDbContext blogsDbContext)
        {
            this.blogsDbContext = blogsDbContext;
        }
        public async Task<List<Category>> GetCategories()
        {
            var categories = blogsDbContext.Categories;

             return await categories.ToListAsync();
        }
    }
}
