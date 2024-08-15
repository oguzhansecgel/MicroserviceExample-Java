# Öğrenim Projeleri

Bu repo, çeşitli teknolojileri ve araçları kullanarak gerçekleştirdiğim alıştırmaları ve projeleri içerir. Bu projeler, microservice mimarisi, Spring Boot, Spring Cloud, Kafka, Elasticsearch, MongoDB ve Docker gibi modern teknolojilerin kullanımını kapsar.

## İçindekiler

- [Proje Hakkında](#proje-hakkında)
- [Kullanılan Teknolojiler](#kullanılan-teknolojiler)
- [Kurulum](#kurulum)
- [Kullanım](#kullanım)
- [API Dokümantasyonu](#api-dokümantasyonu)
- [Örnek Konfigürasyonlar](#örnek-konfigürasyonlar)
- [Kullanıcı Senaryoları](#kullanıcı-senaryoları)
- [Destek](#destek)
- [Sorun Giderme](#sorun-giderme)

## Proje Hakkında

Bu projede aşağıdaki teknolojileri ve teknikleri kullanarak çeşitli alıştırmalar gerçekleştirdim:

- **Kafka**: Mesajlaşma ve asenkron iletişim için Kafka kullanıldı. Kafka, mikroservisler arasında mesaj göndermek için kullanıldı.
- **Elasticsearch**: Arama ve filtreleme işlemleri için Elasticsearch kullanıldı. Elasticsearch, veri üzerinde hızlı ve ölçeklenebilir arama gerçekleştirmek için kullanıldı.
- **MongoDB**: NoSQL veri tabanı olarak MongoDB kullanıldı. MongoDB, veri saklama ve yönetimi için kullanıldı.
- **Spring Boot**: Microservice uygulamaları geliştirmek için kullanıldı. Spring Boot, uygulama yapılandırmasını basitleştirdi ve hızlı geliştirme imkanı sundu.
- **Spring Cloud**: Microservice mimarisi için Spring Cloud kullanıldı. Spring Cloud, servis keşfi, yapılandırma yönetimi ve API gateway işlevlerini sağladı.
- **Spring Config Server**: Konfigürasyon yönetimi için Spring Config Server kullanıldı. Bu, merkezi bir konfigürasyon sunucusu sağladı.
- **Docker**: Uygulama ve servisleri konteynerize etmek için Docker kullanıldı. Docker, geliştirme, test ve dağıtım süreçlerini standartlaştırdı.
- **Feign Client**: Mikroservisler arasında HTTP istekleri yapmak için Feign Client kullanıldı. Feign Client, Product ve Order servisleri arasında iletişim sağladı.

## Kullanılan Teknolojiler

- **Kafka**: [Kafka Resmi Dokümantasyonu](https://kafka.apache.org/documentation/)
- **Elasticsearch**: [Elasticsearch Resmi Dokümantasyonu](https://www.elastic.co/guide/en/elasticsearch/reference/current/index.html)
- **MongoDB**: [MongoDB Resmi Dokümantasyonu](https://www.mongodb.com/docs/manual/)
- **Spring Boot**: [Spring Boot Resmi Dokümantasyonu](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- **Spring Cloud**: [Spring Cloud Resmi Dokümantasyonu](https://spring.io/projects/spring-cloud)
- **Spring Config Server**: [Spring Cloud Config Server Dokümantasyonu](https://cloud.spring.io/spring-cloud-config/)
- **Docker**: [Docker Resmi Dokümantasyonu](https://docs.docker.com/)
- **Feign Client**: [Feign Resmi Dokümantasyonu](https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/)

## Kurulum

Projeyi yerel makinenize klonlamak için:

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
## Kullanım

### Kafka

1. Kafka broker'ını başlatın.
2. Gerekli konfigürasyonları yapın.
3. Mesaj göndermek ve almak için ilgili topic'leri oluşturun.

### Elasticsearch

1. Elasticsearch servisini başlatın.
2. Veri indeksleme işlemleri yaparak arama fonksiyonlarını test edin.

### MongoDB

1. MongoDB servisini başlatın.
2. Veritabanı bağlantılarını yapılandırın.
3. Veri ekleyin ve sorgulayın.

### Spring Boot

1. Spring Boot uygulamalarını başlatın.
2. Uygulamanızın işlevlerini test edin.

### Spring Cloud

1. Spring Cloud Config Server ve diğer Spring Cloud servislerini başlatın.
2. Merkezi konfigürasyonu yönetin.

### Docker

1. Docker ile konteynerleri oluşturun ve başlatın.
2. Uygulamayı Docker konteynerlerinde çalıştırın.

## API Dokümantasyonu

Eğer API'ler mevcutsa, API uç noktaları ve kullanım detayları burada yer alır.

### Uygulama çalıştıktan sonra, API uç noktalarına erişebilirsiniz. Örneğin:

#### ElasticSearch API
- Belirli bir fiyat aralığındaki ürünleri getirmek için: `GET /product/productPriceBetween?lower={lower}&upper={upper}`
- Tüm ürünleri listelemek için: `GET /product/findAll`
- Belirli bir isimle ürünleri aramak için: `GET /product/findByProductName?productName={productName}`

#### Ürün API
- Tüm ürünleri listelemek için: `GET /product/findAll`
- Belirli bir ürünü ID'si ile görmek için: `GET /product/getByIdProduct/{id}`
- Yeni bir ürün eklemek için: `POST /product/createProduct`
- Belirli bir ürünü silmek için: `DELETE /product/deleteProduct/{id}`
- Belirli bir ürünü güncellemek için: `PUT /product/updateProduct/{id}`
- Belirli bir ürünün stoğunun düşmesi için : `PUT /product/decrementStock/{id}`

#### Sipariş API
- Yeni bir sipariş oluşturmak için: `POST /orders/createOrder?productId={productId}`
- Tüm siparişleri listelemek için: `GET /orders/getListByAllOrder`

## Örnek Konfigürasyonlar

### Kafka Konfigürasyonu

```properties
spring.kafka.bootstrap-servers=localhost:9092
```
### Elasticsearch Konfigürasyonu
```properties 
spring.elasticsearch.rest.uris=http://localhost:9200
```
### MongoDB Konfigürasyonu
```properties 
spring.data.mongodb.uri=mongodb://localhost:27017/orderservice

```
## Kullanıcı Senaryoları

- **Kafka ile Mesaj Gönderme**: Kafka kullanarak mikroservisler arasında mesaj gönderin ve alın. Kafka'nın topic yapısını kullanarak veri akışını yönetin ve mesajları işleyin.
- **Elasticsearch ile Arama**: Elasticsearch üzerinde veri indeksleyin ve arama fonksiyonlarını test edin. Verilerinizi hızlı ve ölçeklenebilir bir şekilde aramak için Elasticsearch'ün sorgu yeteneklerini kullanın.
- **MongoDB ile Veri Saklama**: MongoDB'de veri saklayın ve sorgulama işlemleri yapın. MongoDB'nin NoSQL özelliklerinden yararlanarak veri yönetimini gerçekleştirin.
- **Feign Client ile İletişim**: Feign Client kullanarak mikroservisler arasında veri alışverişi yapın. Feign Client, HTTP isteklerini kolayca yönetmenizi sağlar ve servisler arası iletişimi basitleştirir.

## Destek

Herhangi bir sorunuz veya desteğe ihtiyacınız varsa, lütfen [açık bir sorun](https://github.com/oguzhansecgel) oluşturun veya benimle iletişime geçin.


