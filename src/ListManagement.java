import java.util.Scanner;
public class ListManagement {

    int maxLength = 100;

    int length = 0;

    Student[] data = new Student[maxLength];

    Scanner input = new Scanner(System.in);

    public ListManagement() {

    }

    //添加

    public void add() {

        if(length < maxLength) {

            data[length] = new Student();

            System.out.print("请输入学生的学号： ");

            data[length].setId(input.nextInt());

            System.out.print("请输入学生的姓名：");

            data[length].setName(input.next());

            System.out.print("请输入学生的成绩：");

            data[length].setScore(input.nextDouble());

            length++;

            System.out.println("添加成功！");

        }

        else {

            System.out.println("添加失败！");

        }

    }



        //显示成绩单方法

    public void transcript() {

        System.out.println("=====================================");

        System.out.println(" 学号                     姓名                      成绩 ");

        for(int i = 0; i < length; i++) {

            System.out.println(data[i].id + "\t" + data[i].name + "\t" + "\t" + data[i].score);

        }

        System.out.println("=====================================\n");

    }



        //成绩从高往低排序方法

    public void sort() {

        Student temp = new Student();

        for(int i = 1; i < length; i++) {

            for(int j = 0; j < length - i; j++) {

                if(data[j].score < data[j + 1].score) { //冒泡法排序

                    temp = data[j]; data[j] = data[j + 1]; data[j + 1] = temp;

                }

            }

        }

    }



        //平均分、最大最小值方法

    public void average() {

        double sum = 0.0;

        double max = 0.0;

        double min = 100.0;

        for(int i = 0; i < length; i++) {

            sum += data[i].score;

            max = max > data[i].score ? max : data[i].score;

            min = min < data[i].score ? min : data[i].score; //三目运算法

        }

        System.out.printf("这门课的平均成绩为: %.2f\n", sum/length);

        System.out.println("最高分为: " + max + "\n" + "最低分为: " + min + "\n");

    }



        //删除学生记录方法

    public void delete() {

        System.out.print("请输入您要删除信息的学生的学号: ");

        int number1 = input.nextInt();

        int i, flag = length;

        for(i = 0; i < length; i++) {

            if(number1==data[i].id) {

                flag = i; break;

            }

        }

        if(i == length) {

            System.out.println("查无此人！请核对后重新输入 \n");

            delete();

        }

        else {

            for(int j = flag; j < length; j++) {

                data[j] = data[j + 1];

            }

            System.out.println("删除成功！\n");

            length -= 1; //不减1会报数组越界的错误

        }

    }





        //查询某个学生信息方法

    public void inquire() {

        System.out.print("请输入您要查询成绩的学生的学号：");

        int number2 = input.nextInt();

        int i;

        for(i = 0; i < length; i++) {

            if(number2==data[i].id) {

                System.out.println("====================================");

                System.out.println(" 学号                     姓名                      成绩 ");

                System.out.println(data[i].id + "\t" + data[i].name + "\t" + "\t" + data[i].score);

                System.out.println("====================================\n");

                break;

            }

        }

        if(i == length) {

            System.out.println("查无此人！请核对后重新输入学号 \n");

            inquire();

        }

    }



        //修改学生信息方法

    public void recompose() {

        System.out.print("请输入您要修改信息的学生的学号：");

        int number3 = input.nextInt();

        int i;

        for(i = 0; i < length; i++) {

            if(number3==data[i].id) {

                System.out.println("请输入该学生新的学号，姓名和成绩：");

                System.out.println("学号");

                data[i].setId(input.nextInt());

                System.out.println("姓名");

                data[i].setName(input.next());

                System.out.println("成绩");

                data[i].setScore(input.nextDouble());

                System.out.println("修改成功！\n");

                break;

            }

        }

        if(i == length) {

            System.out.println("查无此人！请核对后重新输入学号\n");

            recompose();

        }

    }

}

