using BlogsApi.Helpers;
using BlogsApi.Interfaces;
using Microsoft.AspNetCore.Mvc;
using System.Threading.Tasks;

namespace BlogsApi.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class CategoriesController : ControllerBase
    {
        private readonly ICategoryService categoryService;
        private readonly IBlogService blogService;

        public CategoriesController(ICategoryService categoryService, IBlogService blogService)
        {
            this.categoryService = categoryService;
            this.blogService = blogService;
        }

        [HttpGet]
        [Route("")]
        public async Task<IActionResult> Get()
        {
            var categories = await categoryService.GetCategories();

            var categoryModels = CategoryHelper.ConvertCategories(categories);

            return Ok(categoryModels);
        }

        [HttpGet]
        [Route("{categoryId}/blogs")]
        public async Task<IActionResult> GetCategoryBlogs(int categoryId)
        {
            var blogs = await blogService.GetBlogsUnderCategory(categoryId);

            var blogModels = BlogHelper.ConvertBlogs(blogs);

            return Ok(blogModels);
        }
    }
}