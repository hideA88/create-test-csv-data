# replicate-test-csv

サンプルのcsvからテストデータを生成します


## 使い方

### 準備

1. 実行ディレクトリに`application.conf`を配置して以下のように記述してください
```scala
    conf{
      encoding = "sjis" #fileの文字コード
      file = "sample.csv" #サンプルcsvのファイルパス
      outName = "out.csv" #出力するファイルパス
      incrementIds = ["id", "title"] # インクリメントする列のID
      recordSize = 1000 #生成するデータのレコード数
    }
```  

2. テストデータのサンプルとなるcsvを指定したディレクトリに配置してください

### 実行

　`java -jar replicate-test-csv-assembly-0.0.2.jar`

## 仕様

指定したサンプルCSVの値をベースに指定された行数のcsvファイルを作成します
incrementIdsに指定された列に関しては`${サンプルの値} + ${連番}`で値を生成します

## ビルド

実行可能jarの作り方

`sbt assembly`
