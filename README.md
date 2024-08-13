# Microservice Example with Java Spring

## Proje Açıklaması

Bu proje, Java Spring Boot ve Spring Cloud kullanılarak geliştirilmiş bir mikro servis uygulamasıdır ve Kafka, Elasticsearch gibi teknolojilerin giriş seviye kullanımını gösterir.

## Kullanılan Teknolojiler

- **Java Spring Boot**: Java uygulamaları geliştirmek için kullanılan güçlü bir framework.
- **Java Spring Cloud**: Mikro servisler ve dağıtık sistemler için yapılandırma ve servis keşfi sağlar.
- **Kafka**: Dağıtık akış işleme platformu, olay tabanlı sistemlerde veri akışını yönetir.
- **Elasticsearch**: Dağıtık, RESTful arama ve analitik motoru, büyük veri kümesi üzerinde hızlı arama ve analiz sağlar.
- **Docker**: Uygulamaları konteynerlerde çalıştırmak için kullanılan bir platform, mikro servislerinizi izole ve taşınabilir bir şekilde yönetir.

## Özellikler

- **Mikro Servis Mimarisi**: Uygulama, mikro servisler kullanarak her bileşeni bağımsız olarak ölçeklenebilir ve yönetilebilir.
- **Veri İşleme için Kafka Entegrasyonu**: Kafka kullanılarak yüksek hacimli veri akışları işlenir ve olay tabanlı sistemler desteklenir.
- **Arama ve Analiz için Elasticsearch Entegrasyonu**: Elasticsearch, hızlı ve ölçeklenebilir arama ve analiz işlevleri sunar, büyük veri kümeleri üzerinde etkili sonuçlar sağlar.
- **REST API ile Etkileşim**: Uygulama, RESTful API'ler aracılığıyla diğer servislerle etkileşimde bulunur, veri alışverişi ve entegrasyon sağlar.
- **Docker Desteği**: Uygulama, Docker konteynerlerinde çalıştırılabilir, böylece kolay dağıtım ve izole çalışma ortamları sağlar.

## Kurulum

Projenizi yerel makinenize klonlayın:

```bash
git clone https://github.com/oguzhansecgel/MicroserviceExample-Java.git
cd MicroserviceExample-Java
``` 

Gerekli bağımlılıkları yüklemek için Maven kullanın:
```bash
mvn install
```


Uygulamayı başlatmak için:
```bash
mvn spring-boot:run
```

## Katkıda Bulunma
#### Katkıda bulunmak istiyorsanız, lütfen bir pull request gönderin veya bir sorun bildirin.