/**
 *
 * Copyright (c) 2011 Matthew D Huckaby. All rights reservered.
 * ------------------------------------------------------------------------------------
 * Image2Css is licensed under Apache 2.0, please see LICENSE file.
 *
 * Use of this software indicates you agree to the following as well :
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 * This product includes software developed by The Apache Software Foundation (http://www.apache.org/).
 * ------------------------------------------------------------------------------------
 */
package com.rf1m.image2css.out;

import com.rf1m.image2css.cli.Parameters;
import com.rf1m.image2css.domain.BeanType;
import com.rf1m.image2css.domain.CssClass;
import com.rf1m.image2css.domain.ObjectFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileOutput extends AbstractOutput{
    protected static final String NL = "\n";
    protected final ObjectFactory objectFactory;

    public FileOutput(final ObjectFactory objectFactory) {
        this.objectFactory = objectFactory;
    }

    @Override
    public void out(final Parameters parameters, final List<CssClass> cssClasses) throws IOException {
        if(super.isValidParametersAndClasses(parameters, cssClasses)){
            final FileWriter fileWriter = this.objectFactory.instance(BeanType.fileWriter, parameters.getCssFile());
            final StringBuffer stringBuffer = this.objectFactory.instance(BeanType.stringBuffer);

            for(final CssClass cssClass : cssClasses){
                stringBuffer
                    .append(cssClass.getBody())
                    .append(NL);
			}

            fileWriter.write(stringBuffer.toString());
			fileWriter.close();
		}
    }

    protected ObjectFactory getObjectFactory() {
        return objectFactory;
    }
}