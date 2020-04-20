package ru.aplabs.ub.impl.tinkoff;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SignUtilTests {

    @Test
    public void checkValidCase() {
        String source = "{\n" +
                "    'TerminalKey': 'TinkoffBankTest',\n" +
                "    'Amount': '100000',\n" +
                "    'OrderId': 'TokenExample',\n" +
                "    'Description': 'test',\n" +
                "    'DATA': {\n" +
                "        'Phone': '+71234567890',\n" +
                "        'Email': 'a@test.com'\n" +
                "    },\n" +
                "    'Receipt': {\n" +
                "        'Email': 'a@test.ru',\n" +
                "        'Phone': '+79031234567',\n" +
                "        'Taxation': 'osn',\n" +
                "        'Items': [\n" +
                "            {\n" +
                "                'Name': 'Наименование товара 1',\n" +
                "                'Price': 10000,\n" +
                "                'Quantity': 1.00,\n" +
                "                'Amount': 10000,\n" +
                "                'Tax': 'vat10',\n" +
                "                'Ean13': '0123456789'\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";
        String result = SignUtil.sign(source, "TinkoffBankTest");
        assertEquals("48d4ca825aab2ede06736d3eae099bd56ac97bd1bcdd598aff210f729de4eb21", result);
    }
}
