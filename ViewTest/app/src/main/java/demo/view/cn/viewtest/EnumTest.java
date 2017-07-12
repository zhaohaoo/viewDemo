package demo.view.cn.viewtest;

/**
 * Created by zhaohao on 17/6/21.
 */
public class EnumTest {

    enum Grade {
        A("1"), B("2"), C("3");

        private String Value;

        private Grade(String Value) {
            this.Value = Value;
        }

        public String getValue() {
            return this.Value;
        }
    }
}
