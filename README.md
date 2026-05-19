# 📚 BookVerse — Ứng dụng Bán Sách Android

> Đồ án học phần **Các Công Nghệ Lập Trình Hiện Đại** — Nhóm 35  
> Trường Đại học Sài Gòn — Khoa Công Nghệ Thông Tin

---


---

## 🗂️ Cấu trúc workspace

```
New folder/
├── BookStore/              ← Android app (Kotlin + Jetpack Compose)
├── bookstore-backend/      ← Spring Boot REST API (Java + MySQL)
├── exam-answers/           ← Đáp án kiểm tra thực hành (16 packages)
├── kotlin-examples/        ← Ví dụ Kotlin độc lập (Chương 3 & 4)
├── docs/                   ← Tài liệu báo cáo học phần
│   ├── BaoCao.md                     ← Báo cáo nhóm (định dạng Markdown)
│   ├── bao_cao_ca_nhan_nhom35.md     ← Báo cáo cá nhân 3 thành viên
│   ├── bao_cao_full_pdf.md           ← Bản export từ PDF (bản nộp cuối)
│   └── momo_deeplink_diagram.md      ← Sơ đồ luồng thanh toán MoMo
├── README.md               ← File này
└── SETUP_INTELLIJ.md       ← Hướng dẫn mở cả 2 project trong IntelliJ IDEA
```

---

## 🚀 Khởi động nhanh

> **Yêu cầu:** Docker Desktop, Android Studio (Hedgehog+), IntelliJ IDEA Community, JDK 17+

```bash
# Bước 1 — Clone về máy
git clone https://github.com/L2NT/BookStoreApp.git "New folder"

# Bước 2 — Khởi động Database
cd "New folder/bookstore-backend"
docker-compose up -d          # MySQL :3307 + MailHog :8025 + phpMyAdmin :8090

# Bước 3 — Chạy Backend (IntelliJ IDEA)
# Mở bookstore-backend/ → Run BookstoreDbApplication
# API chạy tại: http://localhost:8081

# Bước 4 — Chạy Android App (Android Studio)
# Mở BookStore/ → cấu hình IP trong RetrofitClient.kt → Run app
```

Chi tiết xem: [`BookStore/README.md`](BookStore/README.md)  
Setup IntelliJ (1 IDE cho cả 2 module): [`SETUP_INTELLIJ.md`](SETUP_INTELLIJ.md)

---

## 📱 Tính năng chính

| Module | Tính năng |
|--------|-----------|
| **Auth** | Đăng ký, Đăng nhập (JWT), Ghi nhớ phiên đăng nhập |
| **Trang chủ** | Danh sách sách nổi bật từ Google Books API, Banner, phân loại theo danh mục |
| **Danh mục** | 12 danh mục sách, lưới hiển thị, lọc/sắp xếp |
| **Tìm kiếm** | Tìm kiếm realtime, lưới kết quả 2 cột |
| **Chi tiết sách** | Ảnh bìa, mô tả, đánh giá sao, thêm vào giỏ |
| **Giỏ hàng** | Quản lý số lượng, mã giảm giá (SALE10/GIAM17/FREESHIP), tổng tiền tự tính |
| **Thanh toán** | COD + MoMo Sandbox (deeplink → app/browser), pre-fill từ profile |
| **Đơn hàng** | Lịch sử đơn hàng (5 tab trạng thái), hủy đơn, thanh toán lại |
| **Tài khoản** | Chỉnh sửa profile, đổi mật khẩu, cài đặt Dark Mode |

---

## ⚙️ Công nghệ sử dụng

### Frontend (Android)
| Công nghệ | Mục đích |
|-----------|----------|
| Kotlin 2.x | Ngôn ngữ lập trình chính |
| Jetpack Compose | UI declarative |
| Material Design 3 | Design system |
| Navigation Compose + Nested Graphs | Điều hướng đa tab |
| Hilt (Dagger) | Dependency Injection |
| Retrofit 2 + OkHttp | Gọi REST API |
| Coroutines + StateFlow | Bất đồng bộ & quản lý state |
| Coil | Load ảnh từ mạng |
| DataStore Preferences | Lưu trữ token JWT |

### Backend (Spring Boot)
| Công nghệ | Mục đích |
|-----------|----------|
| Spring Boot 3 | Framework backend |
| MySQL 8 (Docker) | Database chính |
| Spring Security + JWT | Xác thực & phân quyền |
| JPA / Hibernate | ORM |
| MailHog (Docker) | Server mail giả lập để test |
| MoMo Sandbox | Cổng thanh toán |

---

## 📖 Tài liệu

| File | Nội dung |
|------|----------|
| [`BookStore/README.md`](BookStore/README.md) | Tài liệu kỹ thuật chi tiết: cấu trúc project, navigation graph, bugs đã fix, MoMo integration |
| [`exam-answers/README.md`](exam-answers/README.md) | Hướng dẫn sử dụng 16 packages đáp án kiểm tra |
| [`kotlin-examples/README.md`](kotlin-examples/README.md) | Ví dụ Kotlin độc lập (Chương 3 & 4) |
| [`SETUP_INTELLIJ.md`](SETUP_INTELLIJ.md) | Mở cả Frontend + Backend trong IntelliJ IDEA Community |
| [`docs/BaoCao.md`](docs/BaoCao.md) | Báo cáo học phần nhóm 35 (Markdown) |
| [`docs/bao_cao_ca_nhan_nhom35.md`](docs/bao_cao_ca_nhan_nhom35.md) | Báo cáo cá nhân 3 thành viên |

---

## 🗺️ Kiến trúc Navigation

```
NavHost (startDestination = "home_graph")
├── home_graph      → HomeScreen, SearchScreen, BookDetailScreen
├── category_graph  → CategoryScreen, CategoryDetailScreen
├── cart_graph      → CartScreen, CheckoutScreen
├── account_graph   → AccountScreen, ProfileScreen, OrderHistoryScreen, ...
├── login/{returnRoute}   ← Shared (ngoài graph)
└── register              ← Shared (ngoài graph)
```

---

## 💳 Thanh toán MoMo Sandbox

| Thông tin | Giá trị |
|-----------|---------|
| Số điện thoại | `0000000000` |
| OTP | `000000` |
| PIN | `000000` |

---

## 🔑 Test MoMo yêu cầu IP thực

Thanh toán MoMo redirect về IP máy tính → cần máy tính và điện thoại **cùng mạng WiFi**.  
Xem hướng dẫn cấu hình IP trong [`BookStore/README.md`](BookStore/README.md).

