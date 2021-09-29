package jp.te4a.spring.boot.myapp6;


//なんか使わない。動いたけど。
import jp.te4a.spring.boot.myapp6.BookBean;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.security.InvalidParameterException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;


import org.junit.jupiter.api.*;
import org.springframework.stereotype.Repository;

import static org.junit.jupiter.api.Assertions.*;

@Repository

public class BookBeanTest {
	
	//BookBean bb;
	BookBean bb = new BookBean(null, null, null, null, null); // こっち出すと動く
	
	
	@Test
	void test1() {
		bb.setId(111);
		bb.setWritter("wr");
		bb.setTitle("ti");
		bb.setPublisher("pu");
		bb.setPrice(221);
		
		String expected = "" + 111 + "wr" + "ti" + "pu" + 221;
		
		String actual =  "" + bb.getId() + bb.getWritter() + bb.getTitle() 
		+ bb.getPublisher() + bb.getPrice() ; 
		
		assertEquals(expected, actual);

	}
}
