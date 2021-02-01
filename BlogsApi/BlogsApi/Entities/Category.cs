using System.Collections.Generic;

namespace BlogsApi.Entities
{
    public class Category
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public virtual ICollection<Blog> Blogs { get; set; }
    }
}