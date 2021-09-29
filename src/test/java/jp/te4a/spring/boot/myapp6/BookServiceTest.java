package jp.te4a.spring.boot.myapp6;

import jp.te4a.spring.boot.myapp6.BookService;
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
public class BookServiceTest {
	
BookRepository br = new BookRepository();
BookService bs = new BookService();
	
	//Test用真データ
	BookBean bb = new BookBean(113, 
							   "bs_test_title", 
							   "bs_test_writter",
							   "bs_test_publisher", 
							   223);
	
	//Test用偽データ
	BookBean bb2 = new BookBean(9090, 
								"nisemono_title", 
								"nisemono_writter",
								"nisemono_publisher", 
								810);
	
	@Test 
	void test1(){ 

		bs.save(bb);	//1回目なのでnullが戻る
		BookBean ac2 = bs.save(bb);		//2回目　入ってる
		
		String actual2 =  "" + ac2.getId() + ac2.getTitle() + ac2.getWritter()
		+ ac2.getPublisher() + ac2.getPrice(); 
	
		String expected = "" + 113 + "bs_test_title" + "bs_test_writter" + "bs_test_publisher" + 223;
	
		assertEquals(expected, actual2);
		
	}
	
	@Test
	void test2(){ //findall
		List<BookBean> exp = new ArrayList<>();
		List<BookBean> act = new ArrayList<>();
		
		exp.add(bb);
			
		bs.save(bb);	//1回目なのでnullが戻る
		bs.save(bb);		//2回目　入ってる
		act = bs.findAll();
		
		assertEquals(exp,act);
	}
	
	
	

}