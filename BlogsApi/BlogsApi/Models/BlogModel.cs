using System;
using System.Collections.Generic;

namespace BlogsApi.Models
{
    public class BlogModel
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public string Description { get; set; }
        public string Url { get; set; }
        public string RssFeed { get; set; }
        public DateTime SubmittedDate { get; set; }
        public List<CategoryModel> Categories { get; set; }
    }
}
