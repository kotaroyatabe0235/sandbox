# 概要
## jQueryとは何ですか？
jQueryは、2006年にJohn Resigによって作成された、高速で簡潔なJavaScriptライブラリです。その理念は、より少ないコードで、より多くの機能を実現することです。

jQueryは、HTMLドキュメントの遍歴、イベント処理、アニメーション、およびAjaxインタラクションを簡素化し、迅速なWeb開発に使用します。

jQueryはJavaScriptツールキットで、より少ないコードを書くことで様々なタスクを簡素化することを目的としています。 これはjQueryがサポートする重要なコア特性のリストです。

* DOM操作-jQueryは、Sizzleと呼ばれるクロスブラウザのオープンソースセレクターエンジンを使用することで、DOM要素の選択、それらを遍歴し、その内容の修正を容易にします。
* イベント処理——jQueryは、ユーザーがリンクをクリックするなど、さまざまなイベントをキャプチャするエレガントな方法を提供します。イベントハンドラーを使用して乱雑なHTMLコードを作成する必要はありません。
* AJAXサポート——jQueryは、AJAX技術を使用してレスポンシブで機能豊富なウェブサイトを開発するために多くの助けを提供します。
* アニメーション——jQueryには多くのアニメーション効果が組み込まれており、あなたのウェブサイトで使用できます。
* 軽量——jQueryは非常に軽量なライブラリ——約19kbサイズ（圧縮フォーマット）です。
* クロスブラウザサポート——jQueryクロスブラウザサポート、IE 6.0 +、FF 2.0 +、Safari 3.0 +、Chrome、Opera 9.0 +ブラウザでうまく動作します。
* 最新の技術——jQueryはCSS3セレクターと基本的なXPath文法をサポートします。

## jQueryの使い方は？
jQueryを使う方法は二つあります。
* ローカルインストール - ローカルコンピュータにjQueryライブラリをダウンロードし、HTMLコードに含めることができます。
* CDNバージョンに基づくーーコンテンツ配信ネットワーク（CDN）から直接jQueryライブラリをHTMLコードに含めることができます。

## ローカルインストール
* Https://jquery.com/download/ ウェブページにアクセスして、最新の利用可能なバージョンをダウンロードしてください。
* 今すぐjquery-2.1.3.min.jsファイルをあなたのウェブサイトのディレクトリにダウンロードします。例えば/jquery。

### 例
今、あなたはjQueryライブラリをあなたのHTMLファイルに含めることができます。以下のように——
```html
<html>
   <head>
      <title>The jQuery Example</title>
      <script type="text/javascript"  src="/jquery/jquery-2.1.3.min.js"></script>
		
      <script type="text/javascript">
         $(document).ready(function(){
            document.write("Hello, World!");
         });
      </script>
		
   </head>
	
   <body>

      <h1>Hello</h1>

   </body>
</html>
```

## CDNバージョンに基づく
コンテンツ配布ネットワーク（CDN）から直接jQueryライブラリをHTMLコードに含めることができます。 グーグルとマイクロソフトは最新バージョンのコンテンツリリースを提供しています。

### 例
では、Google CDNのjQueryライブラリを使用して上記の例を書き直しましょう。
```html
<html>
   <head>
      <title>The jQuery Example</title>
      <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js">
      </script>
		
      <script type="text/javascript">
         $(document).ready(function(){
            document.write("Hello, World!");
         });
      </script>
   </head>
	
   <body>

      <h1>Hello</h1>

   </body>
</html>
```

## どうやってjQueryライブラリ関数を呼び出すか？
私たちがやっていることと同じように、jQueryを使ってドキュメントオブジェクトモデル(DOM)を読み込んだり操作したりするには、DOMの準備が整ったら、できるだけ早くイベントなどを追加する必要があります。

イベントを自分のページで動作させたい場合は、$(document).ready()関数内で呼び出す必要があります。 DOMのダウンロードが完了した後、およびページコンテンツがダウンロードされる前に、この関数内のすべてのものがダウンロードされます。

この機能を実現するには、ドキュメントに用意されたイベントを登録しました。以下のように——

```JavaScript
$(document).ready(function() {
   // do stuff when DOM is ready
});
```

上記のjQueryライブラリ関数を呼び出すには、HTMLスクリプトタグを使用します。以下のように——

```html
<html>
   <head>
      <title>The jQuery Example</title>
      <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js">
      </script>

      <script type="text/javascript" language="javascript">
         $(document).ready(function() {
            $("div").click(function() {alert("Hello, world!");});
         });
      </script>

   </head>
	
   <body>
      <div id="mydiv">
         Click on this to see a dialogue box.
      </div>
   </body>
	
</html>
```

## 	カスタムスクリプトの使い方は？
カスタムのJavaScriptファイル：custom.jsで私たちのカスタムコードを作成するのが一番です。以下のように——

```javascript
/* Filename: custom.js */
$(document).ready(function() {
   $("div").click(function() {
      alert("Hello, world!");
   });
});
```
今、私たちはcustom.jsファイルをHTMLファイルに含めることができます。以下のように——
```html
<html>
   <head>
      <title>The jQuery Example</title>
      <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js">
      </script>
		
      <script type="text/javascript" src="/jquery/custom.js"></script>
   </head>
	
   <body>
      <div id="mydiv">
         Click on this to see a dialogue box.
      </div>
   </body>
	
</html>
```

## 複数のライブラリを使う——
複数のライブラリを同時に使用でき、各ライブラリ間で衝突することはありません。 例えば、jQueryとMooTool javascriptライブラリを同時に使用できます。

詳細については、jQuery noConflictメソッドをご覧ください。

## 次の内容
上記の例をよく理解していなくても、あまり心配しないでください。 次の章では、それらをすぐに習得できます。

次のセクションでは、伝統的なJavaScriptの基本概念について説明します。


[戻る](../README.md)