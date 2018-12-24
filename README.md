# java-html-pdf

## 解决场景
使用java生成动态数据的pdf文件



## 方案优点
1.纯html编写，避免繁杂且不直观的java api操作，java只做转换和提供数据源，不参与pdf中渲染逻辑控制

2.使用vue进行数据映射和页面渲染，符合前端开发思路，前后分离



## 运行路线
1.java中带id访问基于vue的ssr服务nuxt

2.nuxt中使用之前的id回调java获取业务数据

3.通过vue ssr服务端生成进行渲染过的html

4.java接收到html通过itext生成pdf

注：由于ssr只支持get请求，所以如果一次将所有数据都通过url传送的方式不太好，因此通过传递id反向查询数据的方式更靠谱



## 准备
1.java8(本人使用)

2.node10(本人使用)



## 快速开始
***需要端口8080和3000，请避免端口冲突***

1.运行spring boot应用JavaHtmlPdfApplication

2.`$ cd nuxt-pdf-template`

3.`$ npm i`

4.`$ npm run dev`

5.访问 http://localhost:8080/java-html-pdf/index.html 输入ID点击下载pdf 或访问 http://localhost:3000/module1/page1/idxxx 直接访问页面

注：项目中的图片是打码后的真实业务图片，数据为伪造



## 技术栈
1.java (废话)

2.vue https://github.com/vuejs/vue

3.nuxt https://github.com/nuxt/nuxt.js

4.nodejs https://nodejs.org/en/

5.itext https://itextpdf.com/

6.(可选)pm2 node项目部署管理工具 https://github.com/Unitech/pm2



## 需要掌握的非常规知识点
1.字体基础知识

2.了解px等像素单位和pt等绝对单位的区别，在打印中基本只会使用百分比和绝对单位



## 注意事项
与样式相关的事项大多都是由于itext解析并没有浏览器那么完美造成的，所以碰到布局问题不要怀疑你的代码，换一种写法总是能达到目的的

1.不要使用像素单位，一定要使用绝对物理单位pt

2.不能使用绝大部分css3样式，由于打印纸是物理单位，所以基本只需要靠百分比和绝对单位就能完美布局，无需考虑页面大小会发生变化。基本上所有的元素都可以通过绝对定位和固定高宽完成

3.不能使用的非css3样式包括但不仅限于 vertical-align

4.绝对定位时设置right时元素必须加宽度，如不加宽度等同于left:0

5.所有设置字体大小并且存在上下两行文字影响间隔时一定要设置line height等于字体大小。itext对于每一行文字都有固定的默认行高，如不设置则pdf行高会和网页中存在明显的差距，在body中已经设置为14.5pt font-size为12pt的时候不需要设置

6.page中必须有一个非绝对定位的元素，不然有可能会出现空白页，所以统一规定每个page中加一个空格符

7.nuxt框架会生成一些没必要的js和div会影响pdf的生成 在nuxt标签前后加了两个标签 begin end 用于在java中截取目标数据 剔除掉不需要的东西

8.不可在js中通过document操作dom，因为vue ssr是node环境，没有document。基本上vue能覆盖百分之90以上的dom操作，实在不行的使用v-html

9.由于itext是遵循xml规范解析的，xml标签必须要闭合，而html中有一些常见标签不需要闭合，比如img br hr input等，这四个标签我已在java代码中进行了闭合处理，如果有不在这里面的标签可在java类PdfUtils.NEED_END_TAG_LIST添加即可

10.设计时能用图片完成的工作就不要写html，每页一张背景图，利用图层重叠控制页面，会变化的数据才写代码

11.字体使用的思源黑体，此字体版权纠纷较小



## 未完成的功能
1.如果使用echarts等图标功能应该怎么做，因为vue ssr是node环境，没有document，不能进行图表api调用
puppeteer https://github.com/GoogleChrome/puppeteer 可以在node端模拟出浏览器环境，有时间我研究一下



## 结语
这只是一种解决问题的思路，后端可以不用java，前端也可以不用vue，如果帮到您了，请点个星

