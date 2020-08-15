/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class loaddata {

   
    public static cauhoi[] ds = {
        new cauhoi("Giải Grand Slam đầu tiên trong năm là giải nào?", "A", "A.Austrlia mở rộng", "B.Wimbledon", "C.Roland Garos", "D.Mỹ mở rộng"),
        new cauhoi("Cùng với Hà Nội T&T (vô địch V-League 2010), CLB nào của Việt Nam tham dự AFC Cup 2011?", "A", "A.Sông Lam Nghệ An", "B.SHB Đà Nẵng", "C.Hoàng Anh Gia Lai", "D.Becamex Bình Dương"),
        new cauhoi("AFC Asian Cup 2011 được tổ chức tại quốc gia nào?", "A", "A.Qatar", "B.Hàn Quốc", "C.Nhật Bản", "D.Iraq"),
        new cauhoi("Đội nào lên ngôi vô địch AFC Asian Cup 2011 tổ chức tại Qatar?", "A", "A.Nhật Bản", "B.Australia", "C.Hàn Quốc", "D.Uzbekistan"),
        new cauhoi("Ai là nhạc sĩ Việt Nam đầu tiên viết opera với tác phẩm “Cô sao” và sau đó là “Người tạc tượng”?", "A", "A.Đỗ Nhuận", " B.Hoàng Vân", "C.Trần Hoàn", " D.Trọng Đài"),
        new cauhoi("Sông Bến Hải và sông Thạch Hãn nằm ở tỉnh nào?", "C", " A.Quảng Bình", "B.Quảng Ninh", "C.Quảng Trị", "D.Quảng Ngãi"),
        new cauhoi("Trong các cây cầu sau, cầu nào là cầu xoay?", "C", "A.Cầu Thanh Trì", "B.Cầu Thị Nại", "C.Cầu Sông Hàn", "D.Cầu Cần Thơ"),
        new cauhoi("Đại Ngu là quốc hiệu của triều đại nào?", "B", "A.Triều Ngô", "B.Triều Hồ", "C.Các chúa Nguyễn", "D.Nhà Tây Sơn"),
        new cauhoi("Các vua Hùng đặt quốc hiệu nước ta là gì?", "A", "A.Văn Lang", "B.Âu Lạc", "C.Vạn Xuân", "D.Đại Việt"),
        new cauhoi("An Dương Vương đặt quốc hiệu nước ta là gì?", "A", "A.Âu Lạc", "B.Vạn Xuân", "C.Đại Cồ Việt", "D.Đại Việt"),
        new cauhoi("Năm 1010, Lý Thái Tổ đã cho xây dựng điện nào ở trung tâm hoàng thành Thăng Long?", "B", "A.Điện Kính Thiên", "B.Điện Càn Nguyên", "C.Điện Càn Chánh", "D.Điện Càn Thành"),
        new cauhoi("(Điêu tàn) là tập thơ đầu tiên của nhà thơ nào?", "B", "A.Anh Thơ", "B.Thế Lữ", "C.Bích Khê", "D.Chế Lan Viên"),
        new cauhoi("Hội nghị chống biến đổi khí hậu lần thứ 17- 2011 được tổ chức tại nước nào?", "C", "A.Đan Mạch (2011)", "B.Mexico (2010)", "C.Nam Phi (2011)", "D.Qatar và Hàn Quốc (2012)"),
        new cauhoi("Ai được bầu làm Tổng bí thư Đảng cộng sản Việt Nam tại Đại hội XI?", "A", "A.Nguyễn Phú Trọng", "B.Nguyễn Sinh Hùng", "C.Trương Tấn Sang", "D.Nguyễn Tấn Dũng"),
        new cauhoi("Tỉnh nào đăng cai tổ chức Năm du lịch Quốc gia 2012?", "A", "A.Thừa Thiên Huế", "B.Hải Phòng", "C.Lâm Đồng", "D.Thanh Hoá"),
        new cauhoi("Sự kiện giờ Trái Đất, sáng kiến của WWF được tổ chức lần đầu tiên vào năm 2007 tại thành phố nào?", "A", "A.Sydney", "B.Tokyo", "C.Bắc Kinh", "D.Singapore"),
        new cauhoi("Bùi Hữu Nghĩa, một trong bốn rồng vàng của vùng Đồng Nai xưa (tức là toàn Nam Bộ ngày nay) là tài năng ở lĩnh vực nào?", "D", "A.Hoạ", "B.Phú", "C.Đàn", "D.Thi"),
        new cauhoi("Giải thưởng nào được lập ra vào năm 2005 được trao cho những người có thành tựu trong việc phát huy và gìn giữ văn hóa dân tộc?", "A", "A.Đào Tấn", "B.Bùi Xuân Phái", "C.Lê Văn Thiêm", "D.Phạm Thuận Dật"),
        new cauhoi("Vai trò chính của vitamin nào là giúp cho quá trình đông máu diễn ra tốt và hạn chế lượng máu bị mất khi bị thương?", "D", "A.Vitamin A", "B.Vitamin D", "C.Vitamin E", "D.Vitamin K"),
        new cauhoi("Cúm và sởi là những bệnh lây truyền qua đường nào?", "B", "A.Tiêu hoá", "B.Hô hấp", "C.Sinh dục", "D.Máu"),
        new cauhoi("Nước nào ở khu vực Đông Nam Á không có địa giới với bất kỳ nước khác?", "A", "A.Philippines", "B.Malaysia", "C.Lào", "D.Thái Lan"),
        new cauhoi("Virus sởi lây truyền qua đường nào?", "B", "A.Tiêu hoá", "B.Hô hấp", "C.Máu", "D.Sinh dục"),
        new cauhoi("Tượng đài Mẹ Suốt nằm bên cạnh con sông nào?", "A", "A.Sông Nhật Lệ", "B.Sông Gianh", "C.Sông Long Đại", "D.Sông Kiến Giang"),
        new cauhoi("The ASEAN WAY-ca khúc chính thức của ASEAN là sáng tác của nhạc sĩ người nước nào?", "A", "A.Thái Lan", "B.Việt Nam", "C.Singapore", "D.Malaysia"),
        new cauhoi("Việt Nam lần đầu tiên vô địch AFF Cup là vào năm nào?","C", "A.2004", "B.2006", "C.2008", "D.2010"),
        new cauhoi("Giáo sư Trần Văn Khê nổi tiếng ở lĩnh vực nào?", "D", "A.Toán học", "B.Thiên văn học,", "C.Lịch sử", "D.Âm nhạc"),
        new cauhoi("CLB nào vô địch FIFA Club World Cup 2010 tổ chức tại Qatar?", "A", "A.Inter Milan", "B.Real Madrid", "C.Bayern Munich", "D.Manchester United"),
        new cauhoi("Phú Yên-tỉnh đăng cai Năm du lịch quốc gia 2011 ở khu vực nào?", "A", "A.Nam Trung Bộ", "B.Tây Nguyên", "C.Đông Bắc Bộ", "D.Tây Nam Bộ"),
        new cauhoi("Bảo tàng Hồ Chí Minh khánh thành vào đúng dịp kỷ niệm lần thứ mấy ngày sinh của chủ tịch Hồ Chí Minh?", "D", "A.70", "B.80", "C.90", "D.100"),
        new cauhoi("Lễ Hội Gióng chính thức được nhận bằng Di sản văn hoá thế giới vào năm nào?", "C", "A.2008", "B.2009", "C.2010", "D.2011"),
        new cauhoi("Phổi, họng, thanh quản, khí quản, phế quản, phổi là những cơ quan thuộc hệ cơ quan nào trong cơ thể người?", "C", "A.Hệ tuần hoàn", "B.Hệ sinh dục", "C.Hệ hô hấp", "D.Hệ thần kinh"),
        new cauhoi("Tổng bí thư Trung ương Đản cộng sản Việt Nam được bầu tại Đại hội XI là ai?", "B", "A.Nguyễn Tấn Dũng", "B.Nguyễn Phú Trọng", "C.Nguyễn Minh Triết", "D.Nguyễn Văn An"),
        new cauhoi("Trong các hàm số lượng giác cơ bản, hàm số nào là hàm số chẵn?", "B", "A.y=sinx", "B.y=cosx", "C.y-cotgx", "D.y=tgx"),
        new cauhoi("Mùa con ong đi lấy mật, mùa con voi xuống sông hút nước, mùa em đi phát rẫy làm nương, anh vào rừng đặt bẫy cài chông” là những câu hát nói về tháng nào?", "C", "A.Tháng Giêng", "B.Tháng hai", "C.Tháng ba", "D.Tháng tư"),
        new cauhoi("Loại vitamin nào mà cơ thể con người có thể tự tổng hợp được nhờ ánh sáng Mặt Trời?", "B", "A.Vitamin A", "B.Vitamin D", "C.Vitamin E", "D.Vitamin K"),
        new cauhoi("Paracetamol thuộc nhóm thuốc nào sau đây?", "B", "A.Thuốc lợi tiểu", "B.Thuốc hạ sốt, giảm đau, chống viêm", "C.Thuốc điều trị tăng huyết áp", "D.Thuốc an thần, bình thân"),
        new cauhoi("Điền từ còn thiếu trong câu thành ngữ:’”…. Không cứu được …gần”.", "C", "A.Lính-Tướng", "B.Chồng-Vợ,", "C.Nước-Lửa", "D.Chó-Mèo"),
        new cauhoi("Thung lũng nổi tiếng ở Mỹ với ngành công nghệ thông tin được đặt tên theo nguyên tố nào?", "B", "A.Sắt", "B.Silic", "C.Asen", "D.Uran"),
        new cauhoi("Thành cổ Sơn Tây do vị vua nào xây dựng nên vào năm 1822?", "B", "A.Gia Long", "B.Minh Mạng", "C.Thiệu Trị", "D.Tự Đứ"),
        new cauhoi("Nhà thơ nào là người Việt Nam đầu tiên nhận Giải thưởng văn học Đông Nam Á vào năm 1996?", "A", "A.Tố Hữu", "B.Nguyễn Đình Thi", "C.Nguyễn Khoa Điềm", "D.Huy Cận"),
        new cauhoi("Tập hợp các số thực được ký hiệu bằng chữ cái nào?", "D", "A.N", "B.Z", "C.Q ", "D.R"),
        new cauhoi("Việt Nam đã đăng cai cuộc thi sắc đẹp nào trong năm 2010?", "B", "A.Hoa hậu thế giới", "B.Hoa hậu Trái Đất", "C.Hoa hậu hoàn vũ", "D.Hoa hậu quốc tế"),
        new cauhoi("Nguyên mẫu của nhân vật Hoàng Kim trong bộ phim “Bí thư tỉnh uỷ” của đạo diễn Trần Quốc Trọng là bí thư của tỉnh (cũ) nào?", "A", "A.Vĩnh Phúc", "B.Hải Hưng", "C.Bắc Thái", "D.Phú Khánh"),
        new cauhoi("Khí nào chiếm 80% thành phần không khí?", "A", "A.N2", "B.O2", "C.H2", "D.Cl2"),
        new cauhoi("Loài hoa nào được chọn là Quốc hoa của Việt Nam?", "A", "A.Hoa sen", "B.Hoa mai", "C.Hoa đào", "D.Hoa hồng"),
        new cauhoi("Bộ phim “The Social Network” về mạng xã hội nào đã đạt giải Quả cầu vàng 2011?", "A", "A.Facebook", "B.Twitter", "C.Yahoo Plus", "D.Opera"),
        new cauhoi("Vận động viên đứng đầu danh sách 100 vận động viên Việt Nam tiêu biểu của năm 2010 là vận động viên Vũ Thị Hương của môn thể thao nào?", "A", "A.Điền kinh", "B.Cờ vua", "C.Karatedo", "D.Cầu lông"),
        new cauhoi("Truyện “Vợ chồng A Phủ” trong tập truyện Tây Bắc của nhà văn Tô Hoài viết về người dân tộc nào?", "C", "A.Vân Kiều", "B.Thái", "C.H’Mông", "D.Tày"),
        new cauhoi("Quốc gia nào giữ chức chủ tịch luân phiên Liên minh châu Âu trong nửa đầu năm 2011?", "A", "A.Hungary", "B.Bungary", "C.Romania", "D.Ucraikne"),
        new cauhoi("Bánh pía là đặc sản có nguồn gốc từ tỉnh nào?", "B,", "A.Bến Tre", "B.Sóc Trăng", "C.Bạc Liêu", "D.Hậu Giang"),
        new cauhoi("Tác phẩm (Thuỷ hử) của Thi Nại Am diễn ra vào triều đại nào của Trung Quốc?","A","A. Triều Tống","B. Triều Nguyên","C. Triều Minh","D. Triều Thanh "),
        new cauhoi("Vạn Thắng Vương là ai ?","A","A. Đinh Bộ Lĩnh","B. Lê Hoàn","C. Lê Lợi","D. Nguyễn Huệ"),
        new cauhoi("Sau khi chiến thắng quân Nam Hán vào năm 938, Ngô Quyền đã đóng đô ở đâu? ","A","A.Hoa Lư","B.Đại La","C.Cổ Loa","D.Phú Xuân"),
//        new cauhoi("minh tuổi con gì? ","C","A.Con tắc kè","B.Con rùa","C.Con rồng","D.Con ốc sên"),
//        new cauhoi("Đầu ken cứng như gì? ","D","A.Bún","B.Thép","C.gang","D.kim cương"),
        
    };

   public ArrayList<cauhoi>data()
   {
       ArrayList<cauhoi> dsc= new ArrayList<>();
       Collections.addAll(dsc,ds);
       return dsc;
   }
}
