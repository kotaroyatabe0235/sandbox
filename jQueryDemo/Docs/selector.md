# jQuery - セレクター
jQueryライブラリは、カスケードスタイルシート(CSS)セレクターを利用して、ドキュメントオブジェクトモデル(DOM)の要素または要素グループに迅速かつ便利にアクセスできるようにします。

jQueryセレクターは、与えられた基準に基づいて、式を利用してDOMから一致する要素を見つける関数です。 簡単に言えば、セレクターはjQueryを使って1つまたは複数のHTML要素を選択することです。 一つの要素が選択されると、選択した要素に対して様々な操作を実行できます。
## $() 工場関数
jQueryセレクターはdollar記号と括弧で始まる——$()。 工場関数$()は、以下の三つの部分を使って、与えられた文書から要素を選ぶ——

### ラベル名

DOMで使用できるタグ名を表します。 例えば、$('p')はドキュメント内のすべての段落<p>を選択します。
	
### ラベルID

DOMで与えられたIDを持つ一つの使用可能なラベルを表します。 例えば、$('#some-id')は、ドキュメントでIDがsome-idを持つ単一の要素を選択します。

### ラベル類

DOMで指定されたクラスの利用可能なラベルを表します。 例えば、$('.some-class')は、ドキュメント内のsome-classクラスを持つすべての要素を選択します。

上記のすべての項目は単独で使用したり、他のセレクターと組み合わせて使用したりできます。 すべてのjQueryセレクターは、いくつかの調整を除いて、同じ原則に基づいています。

注意——工場関数$()はjQuery()関数の同義語です。 したがって、$記号が他の何かと競合する他のJavaScriptライブラリを使用している場合は、$記号をjQuery名で置き換えることができます。また、$()関数の代わりにjQuery()関数を使用することもできます。

### -例
以下はラベルセレクターを使用する簡単な例です。 ラベル名pを持つすべての要素を選択し、それらの背景色を「黄色」に設定します。
```javascript
<html>
   <head>
      <title>The jQuery Example</title>
      <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js">
      </script>

      <script type="text/javascript" language="javascript">
         $(document).ready(function() {
            $("p").css("background-color", "yellow");
         });
      </script>
   </head>
	
   <body>
      <div>
         <p class="myclass">This is a paragraph.</p>
         <p id="myid">This is second paragraph.</p>
         <p>This is third paragraph.</p>
      </div>
   </body>
	
</html>
```

## セレクターの使い方は？
セレクターは非常に有用で、jQueryを使用するすべてのステップでセレクターを使用する必要があります。 それらはHTML文書からあなたが望む正しい要素を得る。

次の表はいくつかの基本的なセレクターを列挙し、例で説明しています。





[戻る](../README.md)