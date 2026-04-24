# 📚 BookStore – Hướng dẫn mở toàn bộ dự án trong IntelliJ IDEA Community

Dự án gồm 2 phần trong cùng một thư mục gốc (`New folder/`):

| Thư mục | Công nghệ | Build system |
|---|---|---|
| `BookStore/` | Android – Jetpack Compose (Frontend) | Gradle (Kotlin DSL) |
| `bookstore-backend/` | Spring Boot 4 + MySQL (Backend) | Maven |

---

## 🛠️ Yêu cầu cài đặt trước

| Công cụ | Phiên bản tối thiểu | Ghi chú |
|---|---|---|
| IntelliJ IDEA Community | 2024.1+ | |
| JDK | 21 | Dùng cho backend |
| Android SDK | API 26+ | Đã có tại `C:\Users\lnnta\AppData\Local\Android\Sdk` |
| Docker Desktop | Bất kỳ | Để chạy MySQL + MailHog |
| Android Emulator | – | Cấu hình trong AVD Manager |

---

## 🚀 Bước 1 – Cài plugin Android vào IntelliJ IDEA Community

> IntelliJ IDEA Community **không đi kèm** Android plugin mặc định.
> Phải cài thêm từ Marketplace.

1. Mở IntelliJ IDEA Community
2. Vào **File → Settings → Plugins → Marketplace**
3. Tìm **"Android"** (publisher: JetBrains)
4. Nhấn **Install** → khởi động lại IDE

---

## 📂 Bước 2 – Mở dự án

1. **File → Open** → chọn thư mục **`New folder`** (thư mục gốc chứa cả 2 project)
2. IntelliJ sẽ tự nhận `modules.xml` đã có sẵn → load cả Backend và Frontend
3. Nếu IDE hỏi _"Trust this project?"_ → chọn **Trust**

---

## 🔗 Bước 3 – Import Backend (Maven)

1. Nếu xuất hiện banner **"Maven projects found"** → nhấn **Import**
2. Hoặc vào **View → Tool Windows → Maven** → nhấn **+** → chọn `bookstore-backend/pom.xml`
3. Maven sẽ tải dependencies và tạo lại file `bookstore_db.iml`

---

## 🤖 Bước 4 – Sync Frontend (Android Gradle)

1. Nếu xuất hiện banner **"Gradle projects found"** → nhấn **Import**
2. Hoặc vào **View → Tool Windows → Gradle** → nhấn **+** → chọn `BookStore/build.gradle.kts`
3. Gradle sync sẽ chạy và tạo lại các file `.iml` trong `BookStore/`

> ⚠️ **Lần đầu setup (offline mode):** Dự án đang cấu hình `offlineMode = true` (dùng cache local).
> Nếu gặp lỗi "Could not resolve dependencies", tắt offline mode:
> **Settings → Build, Execution, Deployment → Gradle → bỏ tick "Offline work"** → sync lại.

### Cấu hình Android SDK trong IntelliJ:
- **File → Project Structure → SDKs → +** → **Android SDK**
- Chọn đường dẫn: `C:\Users\lnnta\AppData\Local\Android\Sdk`

---

## 🐳 Bước 5 – Khởi động Database và MailHog (Docker)

Mở terminal trong IntelliJ (**View → Tool Windows → Terminal**) và chạy:

```powershell
cd bookstore-backend
docker-compose up -d
```

Kiểm tra:
- MySQL: cổng **3307**
- MailHog Web UI: [http://localhost:8025](http://localhost:8025)

---

## ▶️ Bước 6 – Chạy Backend

### Cách 1 – Dùng Run Configuration có sẵn (khuyến nghị):
- Trên thanh toolbar, chọn **"▶ Backend: Spring Boot"** → nhấn ▶

### Cách 2 – Dùng Maven Tool Window:
- **View → Tool Windows → Maven** → `bookstore-backend` → **Plugins → spring-boot → spring-boot:run**

### Cách 3 – Chạy trực tiếp:
- Mở `BookstoreDbApplication.java`
- Nhấn biểu tượng ▶ xanh bên cạnh `main()` → **Run**

Backend sẽ chạy tại: **http://localhost:8081**

---

## 📱 Bước 7 – Chạy Frontend (Android)

1. **Tools → Device Manager** → tạo hoặc khởi động emulator
2. Trên toolbar, chọn module **`app`** và chọn emulator
3. Nhấn ▶ **Run 'app'**

> **Lưu ý**: App kết nối backend qua `10.0.2.2:8081` (địa chỉ localhost từ emulator Android).
> Đảm bảo backend đang chạy trước khi chạy app.

---

## 🗂️ Cấu trúc thư mục sau khi setup

```
New folder/
├── .idea/                          ← Cấu hình IntelliJ (đã tạo sẵn)
│   ├── modules.xml                 ← Khai báo 3 module (Backend + Frontend root + app)
│   ├── gradle.xml                  ← Cấu hình auto-import Gradle
│   └── runConfigurations/
│       ├── Backend_Spring_Boot.xml ← Run config: mvn spring-boot:run
│       └── Docker_Start_Services.xml
├── BookStore/                      ← Android Jetpack Compose app
│   ├── app/
│   └── ...
└── bookstore-backend/              ← Spring Boot REST API
    ├── src/
    ├── docker-compose.yml          ← MySQL + MailHog
    └── pom.xml
```

---

## ⚡ Thứ tự khởi động nhanh (mỗi lần làm việc)

```
1. docker-compose up -d          (trong thư mục bookstore-backend)
2. Run "▶ Backend: Spring Boot"  (từ toolbar IntelliJ)
3. Run "app" trên emulator       (từ toolbar IntelliJ)
```

---

## ❓ Xử lý lỗi thường gặp

| Lỗi | Giải pháp |
|---|---|
| `Cannot resolve symbol` trong backend | Maven → **Reload All Maven Projects** |
| Gradle sync failed | **File → Sync Project with Gradle Files** |
| `Could not resolve dependencies` Gradle | Tắt Offline mode trong **Settings → Gradle** |
| `Module not found: bookstore_db` | Mở Maven tool window → nhấn **+** → chọn `bookstore-backend/pom.xml` |
| `Android SDK not found` | **File → Project Structure → SDKs → +** → chọn `C:\Users\lnnta\AppData\Local\Android\Sdk` |
| `Connection refused` (app → backend) | Kiểm tra backend đang chạy ở cổng 8081 |
| `Unknown host 10.0.2.2` | Đảm bảo emulator đang chạy, không dùng thiết bị thật với IP localhost |
| Docker port conflict | Đổi port trong `docker-compose.yml` và `application.properties` |
| `jbr-21 not found` | Trong **Project Structure → SDKs**, đổi tên SDK hiện có thành `jbr-21` |



