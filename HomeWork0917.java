import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.io.*;
import java.util.Scanner;

public class HomeWork0917 {
    public static void main(String[] args) {

    }

    public static void readFile() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入文件路径（文件格式UTF8）：");
        String s =sc.nextLine();
        File file = new File(s);
        InputStreamReader in = null;
        BufferedReader br = null;
        StringBuilder content = null;
        try {
            in = new InputStreamReader(new FileInputStream(file),"UTF-8");
            br = new BufferedReader(in);
            content = new StringBuilder();
            while ((s=br.readLine())!=null){
                content = content.append(s+"\n");
            }
        } catch (IOException e) {
            System.out.println("文件读取失败");
        }finally {
            in.close();
            br.close();
        }

        System.out.println("----------------- 文件内容 ----------------------");
        System.out.println(content.toString());
    }
}

class Emp implements Serializable {

    private static final long serialVersionUID = 3117003911L;

    String name;
    int age;
    String gender;
    int salary;
    Date hiredate;

    public Emp(String name, int age, String gender, int salary, Date hiredate) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
        this.hiredate = hiredate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return age == emp.age &&
                salary == emp.salary &&
                name.equals(emp.name) &&
                gender.equals(emp.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender, salary);
    }
}