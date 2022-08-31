# How to Use InfluxDB2 in Kotlin Spring

## InfluxDB 2

InfluxDB 가 1 버전이 출시되고 7년 후 2 버전이 출시되면서 상당히 많은 개념들이 변경되었다.  
데이터 저장소의 명칭부터 organization 이라는 workspace 분리를 위한 개념 등 상당히 많은 부분에서 추가 및 개발 되었다.  
해당 내용에 관해서 [정리한 글](https://slogan138.github.io/TIL/Influx/InfluxDB2_%EC%82%AC%EC%9A%A9%EA%B8%B0.html)이 있으니 참고하면 이해하는데 도움이 될것이다.

## influxdb-client-java

InfluxDB 1 버전에서는 [influxdb-java](https://github.com/influxdata/influxdb-java)를 사용하면 되었지만 앞서 설명했듯이 버전간 개념이 많이 변경되어 2 버전에서는 사용이 불가능하다.  
JVM 기반 언어에서 InfluxDB 2 버전을 사용하기 위한 라이브러리로는 [influxdb-client-java](https://github.com/influxdata/influxdb-client-java)가 있다.  


## influxdb-spring

Spring 에서 influx-client-java 를 사용하기 쉽게 [influxdb-spring](https://github.com/influxdata/influxdb-client-java/tree/master/spring) 라이브러리를 제공한다.  
다만 InfluxDB2HealthIndicator Configuration 이 자동으로 등록되어 Spring Actuator 를 사용하지 않고 사용이 불가능해 보였다.(사용할 수 있는 방법이 있다면 공유해주시면 감사하겠습니다.)

## flux-dsl