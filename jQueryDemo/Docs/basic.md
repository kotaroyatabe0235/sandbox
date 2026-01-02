# jQuery - 基礎知識
jQueryはJavaScriptを使用して構築されたフレームワークです。 したがって、jQueryを使用してアプリケーションを開発しても、JavaScriptで利用可能なすべての関数やその他の機能を使用できます。

このセクションでは、jQueryベースのアプリケーションの中で最も基本的な、しかしよく使われる概念を説明します。

## 文字列
文字列はJavaScriptで不変のオブジェクトであり、0個、1つ以上の文字を含む。

以下はJavaScript文字列の正しい例です——
```
"This is JavaScript String"
'This is JavaScript String'
'This is "really" a JavaScript String'
"This is 'really' a JavaScript String"
```

## 数字
数字はJavaScriptで64ビット形式のIEEE 754二重精度値です。 それらは文字列と同じで、不変です。

以下はJavaScript数字の正しい例です——
```
5350
120.27
0.26
```
## ブール値
JavaScriptのブール値はtrueまたはfalseです。 ある数字が0の場合、デフォルトはfalseです。 文字列が空の場合、デフォルトはfalseです——

以下はJavaScriptのブール値の正しい例です——
```
true      // true
false     // false
0         // false
1         // true
""        // false
"hello"   // true
```

## 対象
JavaScriptも同様にオブジェクトの概念をサポートしています。 オブジェクト文字を使ってオブジェクトを1つ作成できます。以下のように——
```javascript
var emp = {
   name: "Zara",
   age: 10
};
```

ドット記号を使って属性を読み書きすることもできます。以下のように——
```javascript
// Getting object properties
emp.name  // ==> Zara
emp.age   // ==> 10

// Setting object properties
emp.name = "Daisy"  // <== Daisy
emp.age  =  20      // <== 20
```
## 配列
配列文字を使って配列を定義できます。以下のように——
```javascript
var x = [];
var y = [1, 2, 3, 4, 5];
```
配列にはlength属性があり、これは反復に非常に有用である——
```javascript
var x = [1, 2, 3, 4, 5];
for (var i = 0; i < x.length; i++) {
   // Do something with x[i]
}
```

## 関数
JavaScriptの関数は名前付きでも匿名でもかまいません。 命名関数はfunctionキーワードで定義できます。以下のように——

```javascript
function named(){
   // do some stuff here
}
```
匿名関数は、通常の関数を定義するのと同じ方法で定義できますが、名前はありません。

匿名関数は変数に割り当てたり、メソッドに渡したりできます。以下のように。
```javascript
var handler = function (){
   // do some stuff here
}
```
jQueryは匿名関数を頻繁に使用します。以下のように——
```javascript
$(document).ready(function(){
   // do some stuff here
});
```

## パラメータ
JavaScript変数argumentsは長さ属性を持つ配列の一種です。 以下の例はこの点をよく説明してくれる——
```javascript
function func(x){
   console.log(typeof x, arguments.length);
}
func();                //==> "undefined", 0
func(1);               //==> "number", 1
func("1", "2", "3");   //==> "string", 3
```
パラメータオブジェクトにもcallee属性があり、内部関数を指しています。 例えば——
```javascript
function func() {
   return arguments.callee; 
}
func();                // ==> func
```

## 文脈
JavaScriptの有名なキーワードthisは常に現在のコンテキストを指します。 一つの関数では、thisのコンテキストは変更できます。これは関数の呼び出し方法によります。
```javascript
$(document).ready(function() {
   // this refers to window.document
});

$("div").click(function() {
   // this refers to a div DOM element
});
```
関数に組み込まれたメソッドcall()とapply()を使って関数呼び出しのコンテキストを指定できます。

この二つの方法の違いは、それらがパラメータを伝達する方法です。 Callメソッドは、すべてのパラメータをパラメータとして関数に渡すことで、applyメソッドは配列のみをパラメータとして受け入れます。

```javascript
function scope() {
   console.log(this, arguments.length);
}

scope() // window, 0
scope.call("foobar", [1,2]);  //==> "foobar", 1
scope.apply("foobar", [1,2]); //==> "foobar", 2
```

## 作用域
一つの変数の作用域は、その変数が属するプログラムの定義範囲です。 JavaScript変数は二つの作用域しかない。
* グローバル変数——グローバル変数にはグローバルスコープがあり、JavaScriptコードの任意の位置で定義できることを意味します。
* 局部変数——局部変数は、その変数が定義された関数でのみ見ることができます。 関数のパラメータはこの関数にとって局部的である。

一つの関数体の中で、同名の局部変数は全局変数より優先される——
```javascript
var myVar = "global";     // ==> Declare a global variable

function ( ) {
   var myVar = "local";   // ==> Declare a local variable
   document.write(myVar); // ==> local
}
```

## コールバック
コールバックは簡単なJavaScript関数で、パラメータまたは選択としていくつかのメソッドに渡されます。 いくつかのコールバックはイベントであり、ある状態をトリガーすると、ユーザーに反応する機会を与え、コールバックを呼び出します。

jQueryのイベントシステムはどの位置でもコールバックを使用します、例えば——
```javascript
$("body").click(function(event) {
   console.log("clicked: " + event.target);
});
```
大所数調はパラメータと文脈を提供します。 イベントハンドラーの例では、一つのEventパラメータを使ってコールバックを呼び出す。

いくつかのコールバックは必須で、他のリターン値はオプションです。 フォームの提出を阻止するために、提出イベント処理プログラムはエラーを返します。以下のように——
```javascript
$("body").click(function(event) {
   console.log("clicked: " + event.target);
});
```
大所数調はパラメータと文脈を提供します。 イベントハンドラーの例では、一つのEventパラメータを使ってコールバックを呼び出す。

いくつかのコールバックは必須で、他のリターン値はオプションです。 フォームの提出を阻止するために、提出イベント処理プログラムはエラーを返します。以下のように——
```javascript
$("#myform").submit(function() {
   return false;
});
```

## 閉包
現在の作用域外に定義された変数が内部作用域に受信されると、クロージャが作成されます。

次の例は、変数counterがcreat、increment、print関数では見えるが、これらの関数の外部では見えないことを示しています。
```javascript
function create() {
   var counter = 0;
   return {
      increment: function() {
         counter++;
      },
		
      print: function() {
         console.log(counter);
      }
   }
}
var c = create();
c.increment();
c.print();     // ==> 1
```
このパターンでは、外部に見えない操作データを持つオブジェクトを作成できます。 注意しなければならないのは、データ隠蔽はオブジェクト指向プログラミングの基礎であるということです。

## 代理モード
代理は一つのオブジェクトで、他のオブジェクトへのアクセスを制御することができます。 それは別のオブジェクトに対して同じインターフェースを実現し、それを呼び出すための任意の方法を渡した。 ここでのもう一つの対象は、通常、本当のテーマと呼ばれます。

エージェントはインスタンス化され、この実際のテーマに取って代わり、リモートアクセスを許可することができます。 クロージャでjQueryのsetArrayメソッドを保存し、以下の方法で再作成することができます——
```javascript
(function() {
   // log all calls to setArray
   var proxied = jQuery.fn.setArray;

   jQuery.fn.setArray = function() {
      console.log(this, arguments);
      return proxied.apply(this, arguments);
   };
})();
```
上記の方法は、そのコードを関数にラップして、代理変数を隠します。 そして、エージェントはすべてのメソッドの呼び出しを記録し、元のメソッドを呼び出します。 Apply(this, arguments)メソッドを使用して、呼び出し側がオリジナルと代理メソッドの区別を区別できないことを保証します。

## 内蔵関数
JavaScriptには便利な組み込み関数のセットがあります。 これらの方法は、文字列、数字、日付を操作するために使用できます。

完全なJavaScript内蔵関数リストは参照できます——  
　[リンク](https://www.tutorialspoint.com/javascript/javascript_builtin_functions.htm)

## ドキュメントオブジェクトモデル
ドキュメントオブジェクトモデルはHTMLの各種要素のツリー構造で、以下のように——
```javascript
<html>
   <head>
      <title>The jQuery Example</title>
   </head>
	
   <body>
      <div>
         <p>This is a paragraph.</p>
         <p>This is second paragraph.</p>
         <p>This is third paragraph.</p>
      </div>
   </body>
	
</html>
```
以下は上記のツリー構造に関するポイントです——
* < html> は他のすべての要素の祖先です。言い換えれば、他のすべての要素は < html> の子孫です。
* < head> と < body> 要素は < html> の子孫であるだけでなく、< html> の子でもある。
* 同様に、< html>は< head>と< body>の祖先であるだけでなく、彼らの父親でもある。
* < p>要素は< div>要素の子供(子孫)であり、<body>と<html>の子孫、それとも他の<p>要素の同世代である。
	
jQueryの概念を学ぶ時、DOMについてある程度の理解はとても役に立ちます。もしDOMを知らないなら、私たちの簡単なチュートリアル[DOMチュートリアル](https://www.tutorialspoint.com/dom/index.htm)を閲覧することをお勧めします。



[戻る](../README.md)