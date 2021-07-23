/*
 * MIT License
 *
 * Copyright (c) 2017 Alexey Saenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.techstart.batchjobservice.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Data class.
 *
 * @author Alexey Saenko (alexey.saenko@gmail.com)
 */
@Data
public class Customer implements Serializable {

    private int id;
    private String name;
    private Calendar birthday;
    private int transactions;

    @Override
    public String toString() {
        return String.format(
            "#%s, %s born on %3$tb %3$te, %3$tY, finished %4$s transactions",
            id,
            name,
            birthday.getTime(),
            transactions
        );
    }

}
