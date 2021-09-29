package jp.te4a.spring.boot.myapp6;

import jp.te4a.spring.boot.myapp6.BookRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


@Service
public class BookRepositoryTest {
	
	BookRepository br = new BookRepository();
	
	//Test用真データ
	BookBean bb = new BookBean(112, 
							   "br_test_title", 
							   "br_test_writter",
							   "br_test_publisher", 
							   222); 
	
	//Test用偽データ
	BookBean bb2 = new BookBean(9090, 
								"nisemono_title", 
								"nisemono_writter",
								"nisemono_publisher", 
								810); 

	
	@Test 
	void test1(){ //saveのテスト　
		
		br.save(bb);	//1回目なのでnullが戻る
		BookBean ac2 = br.save(bb);		//2回目　入ってる
		
		String actual2 =  "" + ac2.getId() + ac2.getTitle() + ac2.getWritter()
		+ ac2.getPublisher() + ac2.getPrice(); 
	
		String expected = "" + 112 + "br_test_title" + "br_test_writter" + "br_test_publisher" + 222;
	
		assertEquals(expected, actual2);	
	}
	
	@Test
	void test2() { //delete 
		
		//削除データの挿入
		br.save(bb);	//1回目なのでnullが戻る
		br.save(bb);		//2回目　入ってる
		

		br.delete(112);//idが112のデータを消す
		assertEquals(null,br.save(bb));
	}
	
	@Test
	void test3(){ //findall
		List<BookBean> exp = new ArrayList<>();
		List<BookBean> act = new ArrayList<>();
		
		exp.add(bb);
		
		br.save(bb);	//1回目なのでnullが戻る
		br.save(bb);		//2回目　入ってる
		act = br.findAll();
		
		assertEquals(exp,act);
	}
	
	
	
}