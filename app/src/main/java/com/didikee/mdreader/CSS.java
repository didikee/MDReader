package com.didikee.mdreader;

/**
 * Created by didik on 2017/3/30.
 */

public class CSS {
    public static final String github = "<style>"+
            "\n" +
            "/* RESET\n" +
            "=============================================================================*/\n" +
            "\n" +
            "html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p, blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn, em, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var, b, u, i, center, dl, dt, dd, ol, ul, li, fieldset, form, label, legend, table, caption, tbody, tfoot, thead, tr, th, td, article, aside, canvas, details, embed, figure, figcaption, footer, header, hgroup, menu, nav, output, ruby, section, summary, time, mark, audio, video {\n" +
            "  margin: 0;\n" +
            "  padding: 0;\n" +
            "  border: 0;\n" +
            "}\n" +
            "\n" +
            "/* BODY\n" +
            "=============================================================================*/\n" +
            "\n" +
            "body {\n" +
            "  font-family: Helvetica, arial, freesans, clean, sans-serif;\n" +
            "  font-size: 14px;\n" +
            "  line-height: 1.6;\n" +
            "  color: #333;\n" +
            "  background-color: #fff;\n" +
            "  padding: 20px;\n" +
            "  max-width: 960px;\n" +
            "  margin: 0 auto;\n" +
            "}\n" +
            "\n" +
            "body>*:first-child {\n" +
            "  margin-top: 0 !important;\n" +
            "}\n" +
            "\n" +
            "body>*:last-child {\n" +
            "  margin-bottom: 0 !important;\n" +
            "}\n" +
            "\n" +
            "/* BLOCKS\n" +
            "=============================================================================*/\n" +
            "\n" +
            "p, blockquote, ul, ol, dl, table, pre {\n" +
            "  margin: 15px 0;\n" +
            "}\n" +
            "\n" +
            "/* HEADERS\n" +
            "=============================================================================*/\n" +
            "\n" +
            "h1, h2, h3, h4, h5, h6 {\n" +
            "  margin: 20px 0 10px;\n" +
            "  padding: 0;\n" +
            "  font-weight: bold;\n" +
            "  -webkit-font-smoothing: antialiased;\n" +
            "}\n" +
            "\n" +
            "h1 tt, h1 code, h2 tt, h2 code, h3 tt, h3 code, h4 tt, h4 code, h5 tt, h5 code, h6 tt, h6 code {\n" +
            "  font-size: inherit;\n" +
            "}\n" +
            "\n" +
            "h1 {\n" +
            "  font-size: 28px;\n" +
            "  color: #000;\n" +
            "}\n" +
            "\n" +
            "h2 {\n" +
            "  font-size: 24px;\n" +
            "  border-bottom: 1px solid #ccc;\n" +
            "  color: #000;\n" +
            "}\n" +
            "\n" +
            "h3 {\n" +
            "  font-size: 18px;\n" +
            "}\n" +
            "\n" +
            "h4 {\n" +
            "  font-size: 16px;\n" +
            "}\n" +
            "\n" +
            "h5 {\n" +
            "  font-size: 14px;\n" +
            "}\n" +
            "\n" +
            "h6 {\n" +
            "  color: #777;\n" +
            "  font-size: 14px;\n" +
            "}\n" +
            "\n" +
            "body>h2:first-child, body>h1:first-child, body>h1:first-child+h2, body>h3:first-child, body>h4:first-child, body>h5:first-child, body>h6:first-child {\n" +
            "  margin-top: 0;\n" +
            "  padding-top: 0;\n" +
            "}\n" +
            "\n" +
            "a:first-child h1, a:first-child h2, a:first-child h3, a:first-child h4, a:first-child h5, a:first-child h6 {\n" +
            "  margin-top: 0;\n" +
            "  padding-top: 0;\n" +
            "}\n" +
            "\n" +
            "h1+p, h2+p, h3+p, h4+p, h5+p, h6+p {\n" +
            "  margin-top: 10px;\n" +
            "}\n" +
            "\n" +
            "/* LINKS\n" +
            "=============================================================================*/\n" +
            "\n" +
            "a {\n" +
            "  color: #4183C4;\n" +
            "  text-decoration: none;\n" +
            "}\n" +
            "\n" +
            "a:hover {\n" +
            "  text-decoration: underline;\n" +
            "}\n" +
            "\n" +
            "/* LISTS\n" +
            "=============================================================================*/\n" +
            "\n" +
            "ul, ol {\n" +
            "  padding-left: 30px;\n" +
            "}\n" +
            "\n" +
            "ul li > :first-child, \n" +
            "ol li > :first-child, \n" +
            "ul li ul:first-of-type, \n" +
            "ol li ol:first-of-type, \n" +
            "ul li ol:first-of-type, \n" +
            "ol li ul:first-of-type {\n" +
            "  margin-top: 0px;\n" +
            "}\n" +
            "\n" +
            "ul ul, ul ol, ol ol, ol ul {\n" +
            "  margin-bottom: 0;\n" +
            "}\n" +
            "\n" +
            "dl {\n" +
            "  padding: 0;\n" +
            "}\n" +
            "\n" +
            "dl dt {\n" +
            "  font-size: 14px;\n" +
            "  font-weight: bold;\n" +
            "  font-style: italic;\n" +
            "  padding: 0;\n" +
            "  margin: 15px 0 5px;\n" +
            "}\n" +
            "\n" +
            "dl dt:first-child {\n" +
            "  padding: 0;\n" +
            "}\n" +
            "\n" +
            "dl dt>:first-child {\n" +
            "  margin-top: 0px;\n" +
            "}\n" +
            "\n" +
            "dl dt>:last-child {\n" +
            "  margin-bottom: 0px;\n" +
            "}\n" +
            "\n" +
            "dl dd {\n" +
            "  margin: 0 0 15px;\n" +
            "  padding: 0 15px;\n" +
            "}\n" +
            "\n" +
            "dl dd>:first-child {\n" +
            "  margin-top: 0px;\n" +
            "}\n" +
            "\n" +
            "dl dd>:last-child {\n" +
            "  margin-bottom: 0px;\n" +
            "}\n" +
            "\n" +
            "/* CODE\n" +
            "=============================================================================*/\n" +
            "\n" +
            "pre, code, tt {\n" +
            "  font-size: 12px;\n" +
            "  font-family: Consolas, \"Liberation Mono\", Courier, monospace;\n" +
            "}\n" +
            "\n" +
            "code, tt {\n" +
            "  margin: 0 0px;\n" +
            "  padding: 0px 0px;\n" +
            "  white-space: nowrap;\n" +
            "  border: 1px solid #eaeaea;\n" +
            "  background-color: #f8f8f8;\n" +
            "  border-radius: 3px;\n" +
            "overflow-x: scroll;\n" +
            "  overflow-y: hidden;\n"+
            "}\n" +
            "\n" +
            "pre>code {\n" +
            "  margin: 0;\n" +
            "  padding: 0;\n" +
            "  white-space: pre;\n" +
            "  border: none;\n" +
            "  background: transparent;\n" +
            "}\n" +
            "\n" +
            "pre {\n" +
            "  background-color: #f8f8f8;\n" +
            "  border: 1px solid #ccc;\n" +
            "  font-size: 13px;\n" +
            "  line-height: 19px;\n" +
            "  overflow: auto;\n" +
            "  padding: 6px 10px;\n" +
            "  border-radius: 3px;\n" +
            "}\n" +
            "\n" +
            "pre code, pre tt {\n" +
            "  background-color: transparent;\n" +
            "  border: none;\n" +
            "}\n" +
            "\n" +
            "kbd {\n" +
            "    -moz-border-bottom-colors: none;\n" +
            "    -moz-border-left-colors: none;\n" +
            "    -moz-border-right-colors: none;\n" +
            "    -moz-border-top-colors: none;\n" +
            "    background-color: #DDDDDD;\n" +
            "    background-image: linear-gradient(#F1F1F1, #DDDDDD);\n" +
            "    background-repeat: repeat-x;\n" +
            "    border-color: #DDDDDD #CCCCCC #CCCCCC #DDDDDD;\n" +
            "    border-image: none;\n" +
            "    border-radius: 2px 2px 2px 2px;\n" +
            "    border-style: solid;\n" +
            "    border-width: 1px;\n" +
            "    font-family: \"Helvetica Neue\",Helvetica,Arial,sans-serif;\n" +
            "    line-height: 10px;\n" +
            "    padding: 1px 4px;\n" +
            "}\n" +
            "\n" +
            "/* QUOTES\n" +
            "=============================================================================*/\n" +
            "\n" +
            "blockquote {\n" +
            "  border-left: 4px solid #DDD;\n" +
            "  padding: 0 15px;\n" +
            "  color: #777;\n" +
            "}\n" +
            "\n" +
            "blockquote>:first-child {\n" +
            "  margin-top: 0px;\n" +
            "}\n" +
            "\n" +
            "blockquote>:last-child {\n" +
            "  margin-bottom: 0px;\n" +
            "}\n" +
            "\n" +
            "/* HORIZONTAL RULES\n" +
            "=============================================================================*/\n" +
            "\n" +
            "hr {\n" +
            "  clear: both;\n" +
            "  margin: 15px 0;\n" +
            "  height: 0px;\n" +
            "  overflow: hidden;\n" +
            "  border: none;\n" +
            "  background: transparent;\n" +
            "  border-bottom: 4px solid #ddd;\n" +
            "  padding: 0;\n" +
            "}\n" +
            "\n" +
            "/* TABLES\n" +
            "=============================================================================*/\n" +
            "\n" +
            "table th {\n" +
            "  font-weight: bold;\n" +
            "}\n" +
            "\n" +
            "table th, table td {\n" +
            "  border: 1px solid #ccc;\n" +
            "  padding: 6px 13px;\n" +
            "}\n" +
            "\n" +
            "table tr {\n" +
            "  border-top: 1px solid #ccc;\n" +
            "  background-color: #fff;\n" +
            "}\n" +
            "\n" +
            "table tr:nth-child(2n) {\n" +
            "  background-color: #f8f8f8;\n" +
            "}\n" +
            "\n" +
            "/* IMAGES\n" +
            "=============================================================================*/\n" +
            "\n" +
            "img {\n" +
            "  max-width: 100%\n" +
            "}"+
            "</style>\n";
}
