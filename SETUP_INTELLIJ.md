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
| Android SDK | API 26+ | Thường tại `C:\Users\<user>\AppData\Local\Android\Sdk` |
| Docker Desktop | Bất kỳ | Để chạy MySQL + MailHog + phpMyAdmin |
| Android Emulator | – | Cấu hình trong AVD Manager |

---

## 🖥️ Thiết lập lần đầu trên máy mới (laptop)

> Thực hiện **một lần duy nhất** khi cài đặt trên máy mới.

### Bước 1 – Clone repo về máy

```powershell
git clone https://github.com/L2NT/BookStoreApp.git "New folder"
```

### Bước 2 – Bật Docker Desktop tự khởi động cùng Windows ⭐

> Làm điều này **ngay khi cài Docker Desktop** để không phải nhớ bật tay mỗi lần.
> Docker Desktop phải chạy nền **trước** khi IntelliJ có thể start containers.

1. Mở **Docker Desktop**
2. Vào **Settings (⚙️) → General**
3. Bật ✅ **"Start Docker Desktop when you sign in to your computer"**
4. Nhấn **Apply & Restart**

Từ đó mỗi lần bật laptop → Docker Desktop tự chạy nền → không cần nghĩ đến nó nữa.

### Bước 3 – Cài plugin Android vào IntelliJ IDEA Community

> IntelliJ IDEA Community **không đi kèm** Android plugin mặc định — phải cài thêm.

1. Mở IntelliJ IDEA Community
2. Vào **File → Settings → Plugins → Marketplace**
3. Tìm **"Android"** (publisher: JetBrains)
4. Nhấn **Install** → khởi động lại IDE

### Bước 4 – Mở dự án

1. **File → Open** → chọn thư mục **`New folder`** (thư mục gốc chứa cả 2 project)
2. IntelliJ sẽ tự nhận `modules.xml` đã có sẵn → load cả Backend và Frontend
3. Nếu IDE hỏi _"Trust this project?"_ → chọn **Trust**

### Bước 5 – Import Backend (Maven)

1. Nếu xuất hiện banner **"Maven projects found"** → nhấn **Import**
2. Hoặc vào **View → Tool Windows → Maven** → nhấn **+** → chọn `bookstore-backend/pom.xml`
3. Maven sẽ tải dependencies và tạo lại file `bookstore_db.iml`

### Bước 6 – Sync Frontend (Android Gradle)

1. Nếu xuất hiện banner **"Gradle projects found"** → nhấn **Import**
2. Hoặc vào **View → Tool Windows → Gradle** → nhấn **+** → chọn `BookStore/build.gradle.kts`
3. Gradle sync sẽ chạy và tạo lại các file `.iml` trong `BookStore/`

> ⚠️ **Lần đầu setup (offline mode):** Nếu gặp lỗi "Could not resolve dependencies":
> **Settings → Build, Execution, Deployment → Gradle → bỏ tick "Offline work"** → sync lại.

**Cấu hình Android SDK trong IntelliJ:**
- **File → Project Structure → SDKs → +** → **Android SDK**
- Chọn đường dẫn: `C:\Users\<tên_user>\AppData\Local\Android\Sdk`

### Bước 7 – Kiểm tra Run Configurations

Nhấn vào dropdown ▶ trên toolbar — phải thấy đủ 3 config sau:

| Tên | Tác dụng |
|-----|---------|
| `Docker: Start DB` | Chạy `docker-compose up -d` — khởi động MySQL + MailHog + phpMyAdmin |
| `Backend: Spring Boot` | Chạy Spring Boot tại cổng 8081 |
| `app` | Chạy Android app trên emulator |

> ⚠️ Nếu **"Docker: Start DB"** bị mất sau khi clone:
> **Run → Edit Configurations → + → Shell Script**
> - Name: `Docker: Start DB`
> - Script text: `docker-compose up -d`
> - Working directory: chọn thư mục `bookstore-backend/`

---

## ⚡ Thứ tự khởi động mỗi lần làm việc

> Docker Desktop đã tự chạy nền khi bật máy (Bước 2 ở trên).
> Chỉ cần 3 click trong IntelliJ:

```
▶ "Docker: Start DB"        → MySQL + MailHog + phpMyAdmin sẵn sàng
▶ "Backend: Spring Boot"    → API chạy tại http://localhost:8081
▶ Run "app" trên emulator   → Android app kết nối backend
```

**Kiểm tra sau khi khởi động:**

| Service | URL | Ghi chú |
|---------|-----|---------|
| Backend API | http://localhost:8081 | Spring Boot |
| phpMyAdmin | http://localhost:8090 | Quản lý DB — user `root` / pass `root` |
| MailHog | http://localhost:8025 | Xem email test |

---

## 🗂️ Cấu trúc thư mục

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
├── bookstore-backend/              ← Spring Boot REST API
│   ├── src/
│   ├── docker-compose.yml          ← MySQL + MailHog + phpMyAdmin
│   └── pom.xml
└── exam-answers/                   ← Đáp án kiểm tra thực hành
    └── README.md
```

---

## ❓ Xử lý lỗi thường gặp

| Lỗi | Giải pháp |
|---|---|
| `Cannot resolve symbol` trong backend | Maven → **Reload All Maven Projects** |
| Gradle sync failed | **File → Sync Project with Gradle Files** |
| `Could not resolve dependencies` Gradle | Tắt Offline mode trong **Settings → Gradle** |
| `Module not found: bookstore_db` | Mở Maven tool window → nhấn **+** → chọn `bookstore-backend/pom.xml` |
| `Android SDK not found` | **File → Project Structure → SDKs → +** → chọn thư mục Android SDK |
| `Connection refused` (app → backend) | Kiểm tra backend đang chạy ở cổng 8081 |
| `Unknown host 10.0.2.2` | Đảm bảo emulator đang chạy, không dùng thiết bị thật với IP localhost |
| Docker containers không start | Kiểm tra Docker Desktop đang chạy ở system tray |
| Docker port conflict | Đổi port trong `docker-compose.yml` và `application.properties` |
| `jbr-21 not found` | Trong **Project Structure → SDKs**, đổi tên SDK hiện có thành `jbr-21` |
| phpMyAdmin không mở được | Chạy `docker ps` kiểm tra container `bookstore_phpmyadmin` đang chạy |

