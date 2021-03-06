/*
 * Copyright 2018-2019 Niels Gron and Contributors All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package quicksilver.commons.datafeed;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import tech.tablesaw.io.Source;
import tech.tablesaw.io.xlsx.XlsxReader;

public class DataFeedXLSX extends DataFeed {

    public DataFeedXLSX(String baseURLString) {
        super(baseURLString);
    }

    @Override
    protected void buildDataSet() throws IOException {
        //TODO: Add an #anchor feature to select which sheet to load?
        dataTable = new XlsxReader().read(new Source(new ByteArrayInputStream(dataPayload)));
    }

}
