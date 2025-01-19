# Bookstore API

## Mô tả
Ứng dụng Bookstore API cho phép quản lý sách và tác giả, bao gồm các thao tác CRUD (Tạo, Đọc, Cập nhật, Xóa) cho sách và tác giả. Ứng dụng sử dụng Spring Boot và PostgreSQL.

## Cấu hình

Ứng dụng yêu cầu cấu hình cơ sở dữ liệu PostgreSQL và các bước thiết lập môi trường.

### Yêu cầu hệ thống
- Java 8 hoặc cao hơn
- Maven
- PostgreSQL

### Cài đặt và cấu hình ứng dụng

#### Bước 1: Cài đặt và cấu hình cơ sở dữ liệu PostgreSQL

1. **Cài đặt PostgreSQL**:
   - Tải và cài đặt PostgreSQL từ [trang chủ PostgreSQL](https://www.postgresql.org/download/).
   
2. **Tạo cơ sở dữ liệu**:
   - Sau khi cài đặt PostgreSQL, tạo cơ sở dữ liệu bằng lệnh SQL dưới đây:

     ```sql
     CREATE DATABASE bookstore;
     ```

3. **Cấu hình kết nối cơ sở dữ liệu**:
   - Mở file `src/main/resources/application.properties` và thay đổi thông tin cấu hình sau:

     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/bookstore
     spring.datasource.username=your_db_username
     spring.datasource.password=your_db_password
     spring.datasource.driver-class-name=org.postgresql.Driver
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
     spring.jpa.show-sql=true
     ```

   - Thay thế `your_db_username` và `your_db_password` với thông tin đăng nhập của bạn.

#### Bước 2: Cài đặt các phụ thuộc dự án

1. **Cài đặt Maven**:
   - Nếu bạn chưa cài đặt Maven, tải và cài đặt từ [trang chủ Maven](https://maven.apache.org/download.cgi).
   - Kiểm tra cài đặt Maven bằng lệnh:

     ```bash
     mvn -v
     ```

2. **Cài đặt các thư viện phụ thuộc**:
   - Trong thư mục gốc của dự án, mở terminal và chạy lệnh sau để cài đặt các thư viện cần thiết:

     ```bash
     mvn clean install
     ```

#### Bước 3: Chạy ứng dụng

1. **Chạy ứng dụng qua Maven**:
   - Sau khi cài đặt xong các phụ thuộc, bạn có thể chạy ứng dụng bằng lệnh:

     ```bash
     mvn spring-boot:run
     ```

2. **Chạy ứng dụng qua IDE**:
   - Bạn có thể chạy ứng dụng từ IDE của mình (ví dụ IntelliJ IDEA, Eclipse) bằng cách mở lớp `BookstoreApplication.java` và chạy như một ứng dụng Java.

### Kiểm tra API trên Swagger

Ứng dụng đã tích hợp Swagger UI để bạn dễ dàng thử nghiệm các API.

1. **Truy cập Swagger UI**:
   - Sau khi ứng dụng đã được khởi động thành công, mở trình duyệt và truy cập URL sau:

     ```
     http://localhost:8081/swagger-ui.html
     ```

   - Đây là giao diện Swagger UI, nơi bạn có thể thử nghiệm và kiểm tra các API của ứng dụng.

2. **Tạo yêu cầu API**:
   - Trên Swagger UI, bạn có thể kiểm tra các API RESTful như tạo mới sách, lấy thông tin sách, cập nhật sách, và xóa sách.
   - Bạn chỉ cần nhấn vào các endpoint, nhập tham số cần thiết và nhấn "Execute" để gửi yêu cầu.

### API Endpoints

#### **Quản lý sách**
- **POST /api/books**: Tạo mới sách
  - Tham số đầu vào: Một đối tượng `Book` (JSON).
  - Trả về: Đối tượng `Book` vừa tạo.

- **GET /api/books/{id}**: Lấy thông tin chi tiết sách theo ID
  - Tham số đầu vào: `id` của sách.
  - Trả về: Đối tượng `Book` với thông tin chi tiết.

- **GET /api/books**: Lấy danh sách tất cả sách
  - Tham số đầu vào (tùy chọn): 
    - `authorId`: Lọc theo `author_id`.
    - `title`: Lọc theo tên sách.
    - `price`: Lọc theo giá sách.
  - Trả về: Danh sách sách.

- **PUT /api/books/{id}**: Cập nhật thông tin sách
  - Tham số đầu vào: `id` của sách và đối tượng `Book` (JSON) mới.
  - Trả về: Đối tượng `Book` đã cập nhật.

- **DELETE /api/books/{id}**: Xóa sách theo ID
  - Tham số đầu vào: `id` của sách cần xóa.
  - Trả về: Mã trạng thái HTTP.

#### **Quản lý tác giả**
- **POST /api/authors**: Tạo mới tác giả
  - Tham số đầu vào: Một đối tượng `Author` (JSON).
  - Trả về: Đối tượng `Author` vừa tạo.

- **DELETE /api/authors/{id}**: Xóa tác giả theo ID
  - Tham số đầu vào: `id` của tác giả cần xóa.
  - Trả về: Mã trạng thái HTTP.

### Các thông số cấu hình khác

- **`spring.jpa.hibernate.ddl-auto`**: Quy định hành vi của Hibernate đối với cơ sở dữ liệu. Các giá trị có thể là:
  - `none`: Không tự động thay đổi cơ sở dữ liệu.
  - `update`: Tự động cập nhật cấu trúc bảng theo mô hình JPA.
  - `create`: Tạo lại cơ sở dữ liệu mỗi khi ứng dụng khởi động.
  - `create-drop`: Tạo lại cơ sở dữ liệu mỗi khi ứng dụng khởi động và xóa khi ứng dụng dừng.

- **`spring.jpa.show-sql`**: Nếu thiết lập là `true`, Hibernate sẽ hiển thị các câu lệnh SQL trong log.

## Lời kết

Ứng dụng Bookstore API cho phép bạn quản lý sách và tác giả dễ dàng với các tính năng CRUD thông qua các API RESTful. Để triển khai ứng dụng, chỉ cần cấu hình cơ sở dữ liệu PostgreSQL và chạy ứng dụng Spring Boot là bạn đã sẵn sàng sử dụng.

Nếu bạn gặp phải vấn đề gì trong quá trình cài đặt hoặc chạy ứng dụng, đừng ngần ngại liên hệ hoặc tạo issue trên GitHub.

---

**Chúc bạn thành công!**
