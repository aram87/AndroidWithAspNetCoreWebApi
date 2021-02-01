using Microsoft.EntityFrameworkCore;

namespace BlogsApi.Entities
{
    public class BlogsDbContext : DbContext
    {
        public DbSet<Blog> Blogs { get; set; }
        public DbSet<Category> Categories { get; set; }
        public BlogsDbContext(DbContextOptions<BlogsDbContext> options) : base(options)
        {
        }
        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Blog>().ToTable("Blog");
            modelBuilder.Entity<Category>().ToTable("Category");
            modelBuilder.Entity<Blog>().HasMany(s => s.Categories).WithMany(c => c.Blogs);
        }
    }
}