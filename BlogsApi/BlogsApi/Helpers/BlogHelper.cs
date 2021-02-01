using BlogsApi.Entities;
using BlogsApi.Models;
using System.Collections.Generic;
using System.Linq;

namespace BlogsApi
{
    public class BlogHelper
    {
        public static List<BlogModel> ConvertBlogs(List<Blog> blogs)
        {
            var blogModels = blogs.ConvertAll(blog => new BlogModel
            {
                Id = blog.Id,
                Name = blog.Name,
                Description = blog.Description,
                Url = blog.Url,
                RssFeed = blog.RssFeed,
                SubmittedDate = blog.TS,
                Categories = blog.Categories.ToList().ConvertAll(category => new CategoryModel { Id = category.Id, Name = category.Name })
            });
         
            return blogModels;
        }
    }
}
