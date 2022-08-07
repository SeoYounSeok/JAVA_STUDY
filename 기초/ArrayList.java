// ArrayList 관련 샘플 자바 코드를 입력한다.
// Generic 을 사용합니다.
// ArrayList는 List 인터페이스를 상속받은 클래스로 크기가 가변적으로 변하는 선형리스트이다.

public class ArrayList {
    ArrayList<Book> library = new ArrayList<Book>();
    library.add(new Book('라이브러리1', '서윤석'));
    library.add(new Book('라이브러리2', '서윤석'));
    library.add(new Book('라이브러리3', '서윤석'));

    for(Book book:library){
        book.showBookInfo();
    }
}
