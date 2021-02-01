using BlogsApi.Entities;
using BlogsApi.Models;
using System.Collections.Generic;

namespace BlogsApi.Helpers
{
    public class CategoryHelper
    {
        public static List<CategoryModel> ConvertCategories(List<Category> categories)
        {
            var categoryModels = categories.ConvertAll(category => new CategoryModel
            {
                Id = category.Id,
                Name = category.Name,
            });

            return categoryModels;
        }
    }
}
