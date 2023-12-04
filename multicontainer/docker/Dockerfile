FROM openjdk:20

# 作業ディレクトリの指定
WORKDIR /app

# Mavenのインストールディレクトリを設定
ENV MAVEN_HOME /opt/maven

# Mavenのダウンロードとインストール
RUN tar -xvf ./apache-maven-3.9.2-bin.tar /opt \ && ln -s ${MAVEN_HOME}/bin/mvn /usr/bin/mvn

# Mavenの設定ファイルをコピー
# COPY settings.xml ${MAVEN_HOME}/conf/settings.xml
