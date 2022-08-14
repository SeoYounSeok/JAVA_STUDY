public class BookTest {
    public static void main(String[] args) {
        // 첫번째 책 값 설정
        Book firstBook = new Book();
        firstBook.setAuthor("조정래");
        firstBook.setTitle("태백산맥");
        
        // 두번째 책 값 설정
        Book secondBook = new Book();
        secondBook.setAuthor("박완서");
        secondBook.setTitle("나목");
        
        // 세번째 책 값 설정
        Book thirdBook = new Book();
        thirdBook.setAuthor("박경리");
        thirdBook.setTitle("토지");
        
        System.out.println(firstBook.toString());
        System.out.println(secondBook.toString());
        System.out.println(thirdBook.toString());
    }
}