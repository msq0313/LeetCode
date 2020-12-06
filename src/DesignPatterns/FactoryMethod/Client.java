package DesignPatterns.FactoryMethod;

import org.junit.Test;

public class Client {

    @Test
    public void test() {
        SurgicalMaskFactory surgicalMaskFactory = new SurgicalMaskFactory();
        // 输出：这是医用口罩
        System.out.println(surgicalMaskFactory.create());
        N95MaskFactory N95MaskFactory = new N95MaskFactory();
        // 输出：这是 N95 口罩
        System.out.println(N95MaskFactory.create());
    }
}