public class Book {
    private String author;
    private String title;


	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

    @Override
    public String toString(){
        return author + ", " + title;
    }

}
