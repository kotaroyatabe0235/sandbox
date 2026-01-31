# jQuery
jQueryは、2006年にJohn Resigによって作成された
高速で簡潔なJavaScriptライブラリです。 jQueryは、
HTMLドキュメントの遍歴、イベント処理、アニメーション、およびAjaxインタラクションを簡素化し、迅速なWeb開発に使用できます。

## 読者
このチュートリアルは、基本的なjQueryとそのプログラミング概念をわかりやすく学びたいソフトウェアプログラマーのために設計されています。 このチュートリアルでは、適切な例でjQueryのコンポーネントを十分に理解することができます。

## 前提条件
このチュートリアルの学習を始める前に、HTML、CSS、JavaScript、ドキュメントオブジェクトモデル（DOM）および任意のテキストエディタについて基本的な理解が必要です。 私たちはjQueryを使ってウェブベースのアプリケーションを開発するので、インターネットとウェブベースのアプリケーションがどのように機能するかについて基本的な理解があれば、このチュートリアルの学習に多少役立つでしょう。

## jQueryをオンラインで実行する
このチュートリアルで与えられたほとんどの例では、try itオプションを見つけることができますので、このオプションを現場で使用してjQueryプロジェクトを実行し、学習を楽しんでください。

以下のサンプルのコードボックスの右上隅にある、以下のサンプルのtry itオプションを使ってみてください。

```html
<html>
   <head>
      <title>The jQuery Example</title>
      <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js">
      </script>

      <script type="text/javascript">
         $(document).ready(function(){document.write("Hello, World!");});
      </script> 
	 </head>
	 <body>
      <h1>Hello</h1>
   </body>
</html>
```

# 目次
* [概要](./Docs/overview.md)
* [基礎](./Docs/basic.md)
* [セレクター](./Docs/selector.md)