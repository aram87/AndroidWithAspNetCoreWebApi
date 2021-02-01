using BlogsApi.Entities;
using System.Collections.Generic;
using System.Threading.Tasks;
namespace BlogsApi.Interfaces
{
    public interface ICategoryService
    {
        Task<List<Category>> GetCategories();
    }
}