package http.request;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CookiesTest {

    @DisplayName("쿠키를 파싱하여 저장한다.")
    @Test
    void createCookies() {
        Cookies cookies = new Cookies("logined=true; SESSION=abcdefg");
        Map<String, String> result = cookies.getCookies();

        assertThat(result).hasSize(2);
        assertThat(result.get("logined")).isEqualTo("true");
        assertThat(result.get("SESSION")).isEqualTo("abcdefg");
    }

    @DisplayName("잘못된 문자열은 쿠키에 저장하지 않는다.")
    @Test
    void createCookies2


            () {
        Cookies cookies = new Cookies("logined=true; SESSION");
        Map<String, String> result = cookies.getCookies();

        assertThat(result).hasSize(1);
        assertThat(result.get("logined")).isEqualTo("true");
    }
}
