/* 
 * Copyright (C) 2022  ST-Lab
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.urbcomp.cupid.db.flink.source;

import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

public class MyTransactionSource implements SourceFunction<Transaction> {
    private static final long serialVersionUID = 1L;

    private static final Timestamp INITIAL_TIMESTAMP = Timestamp.valueOf("2020-01-01 00:00:00");
    private static final long SIX_MINUTES = 6 * 60 * 1000;

    private final boolean bounded;        // 标志变量，指示生成流数据还是批数据

    private int index = 0;                // 交易记录的索引
    private long timestamp;               // 交易发生的时间戳

    private volatile boolean isRunning = true;
    private final List<Transaction> data;

    public MyTransactionSource(boolean bounded) {
        this.bounded = bounded;
        this.timestamp = INITIAL_TIMESTAMP.getTime();

        // 事先存储的信用卡交易数据，在实际中来自于外部数据源系统（如Kafka）
        data = Arrays.asList(
            new Transaction(1, 0L, 188.23),
            new Transaction(2, 0L, 374.79),
            new Transaction(3, 0L, 112.15),
            new Transaction(4, 0L, 478.75),
            new Transaction(5, 0L, 208.85),
            new Transaction(1, 0L, 379.64),
            new Transaction(2, 0L, 351.44),
            new Transaction(3, 0L, 320.75),
            new Transaction(4, 0L, 259.42),
            new Transaction(5, 0L, 273.44),
            new Transaction(1, 0L, 267.25),
            new Transaction(2, 0L, 397.15),
            new Transaction(3, 0L, 0.219),
            new Transaction(4, 0L, 231.94),
            new Transaction(5, 0L, 384.73),
            new Transaction(1, 0L, 419.62),
            new Transaction(2, 0L, 412.91),
            new Transaction(3, 0L, 0.77),
            new Transaction(4, 0L, 22.10),
            new Transaction(5, 0L, 377.54),
            new Transaction(1, 0L, 375.44),
            new Transaction(2, 0L, 230.18),
            new Transaction(3, 0L, 0.80),
            new Transaction(4, 0L, 350.89),
            new Transaction(5, 0L, 127.55),
            new Transaction(1, 0L, 483.91),
            new Transaction(2, 0L, 228.22),
            new Transaction(3, 0L, 871.15),
            new Transaction(4, 0L, 64.19),
            new Transaction(5, 0L, 79.43),
            new Transaction(1, 0L, 56.12),
            new Transaction(2, 0L, 256.48),
            new Transaction(3, 0L, 148.16),
            new Transaction(4, 0L, 199.95),
            new Transaction(5, 0L, 252.37),
            new Transaction(1, 0L, 274.73),
            new Transaction(2, 0L, 473.54),
            new Transaction(3, 0L, 119.92),
            new Transaction(4, 0L, 323.59),
            new Transaction(5, 0L, 353.16),
            new Transaction(1, 0L, 211.90),
            new Transaction(2, 0L, 280.93),
            new Transaction(3, 0L, 347.89),
            new Transaction(4, 0L, 459.86),
            new Transaction(5, 0L, 82.31),
            new Transaction(1, 0L, 373.26),
            new Transaction(2, 0L, 479.83),
            new Transaction(3, 0L, 454.25),
            new Transaction(4, 0L, 83.64),
            new Transaction(5, 0L, 292.44)
        );
    }

    @Override
    public void run(SourceContext<Transaction> sourceContext) {
        while (this.isRunning && this.hasNext()) {
            sourceContext.collect(this.next());
        }
    }

    @Override
    public void cancel() {
        this.isRunning = false;
    }

    private boolean hasNext() {
        // 如果还有数据
        if (index < data.size()) {
            return true;
        }
        // 如果是用于生成批数据
        else if (bounded) {
            return false;
        }
        // 如果是用于生成流数据，从头循环
        else {
            index = 0;
            return true;
        }

    }

    // 生成下一个交易数据，交易时间相隔6分钟
    private Transaction next() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Transaction transaction = data.get(index++);
        transaction.setTimestamp(timestamp);
        timestamp += SIX_MINUTES;
        return transaction;
    }
}
