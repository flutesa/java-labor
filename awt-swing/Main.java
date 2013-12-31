import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

import javax.swing.*;


class Global {
    public static int s;
}


public class Main {
    public static void main(String[] args) {
//        Two();       //нет эффекта упругости
//        Four();   // ok
        Six();      // ok
//        Eight();  //    ok
//        Ten();    //   ok
//        Twelve(); //   ok
    }

    public static void Two(){
        JFrame fr=new JFrame("”пруга€ окружность");
        fr.setPreferredSize( new Dimension(400, 400));
        final JPanel pan = new JPanel();

        fr.add(pan);
        fr.setVisible(false);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();

        Timer tm = new Timer(500, new ActionListener(){
            int i=0,x=100,y=100,delta = 20,r = 50;
            @Override
            public void actionPerformed(ActionEvent e) {
                Graphics2D gr = (Graphics2D)pan.getRootPane().getGraphics();
                pan.update(gr);

                GeneralPath path = new GeneralPath();
                path.append(new Ellipse2D.Double(x, y, r, r), true);
                if(x+delta+r>=400 || x<=0)
                    delta*=-1;

                AffineTransform tranforms = AffineTransform.getRotateInstance(i, x+=delta, y);
                gr.transform(tranforms);
                AffineTransform tranf = AffineTransform.getRotateInstance(i, x+=delta, y);
                gr.draw(path);
            }
        });
        tm.start();
    }

    public static void Four(){
        JFrame fr=new JFrame("ќтрезок");
        fr.setPreferredSize( new Dimension(400, 400));
        final JPanel pan = new JPanel();

        fr.add(pan);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();

        Timer tm = new Timer(500, new ActionListener(){
            int i=0,x=100,y=200;
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Graphics2D gr = (Graphics2D)pan.getRootPane().getGraphics();
                pan.update(gr);

                GeneralPath path = new GeneralPath();
                //Line2D line = new Line2D.Double(100, 100, 200, 200);
                path.append(new Line2D.Double(x, x, y, y), true);

                gr.setColor(Color.getHSBColor((float) 0.1*i, 1, 1));

                AffineTransform tranforms = AffineTransform.getRotateInstance((i++), y, y);
                gr.transform(tranforms);
                gr.draw(path);
            }
        });
        tm.start();
    }

    public static void Six(){
        JFrame fr=new JFrame("Вращение четырехугольника вокруг центра тяжести");
        fr.setPreferredSize(new Dimension(400,400));

        final JPanel pan= new JPanel();

        fr.add(pan);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();

        Timer tm= new Timer(400, new ActionListener(){
            int i=0, x=100, y=100, w = 50, h = 80;

            @Override
            public void actionPerformed(ActionEvent arg0) {
                Graphics2D gr=(Graphics2D)pan.getRootPane().getGraphics();
                pan.update(gr);

                GeneralPath path=new GeneralPath();

//                path.append(new Rectangle(x,y,w,h),true);
//
//                float centerX = x + (w)/2;
//                float centerY = y + (h)/2;
//                было квадратом, переписали на ромб

                Polygon rhomb = new Polygon();
                rhomb.addPoint(x, w+y);
                rhomb.addPoint(h+x, y);
                rhomb.addPoint(h*2+x, w+y);
                rhomb.addPoint(h+x, w*2+y);

                path.append(rhomb, true);

                float centerX = x+h;
                float centerY = y+w;

                AffineTransform tranforms = AffineTransform.getRotateInstance((i++)*0.5, centerX, centerY);
                gr.transform(tranforms);
                gr.draw(path);
            }
        });
        tm.start();
    }

    public static void Eight(){
        JFrame fr=new JFrame("“очка");
        fr.setPreferredSize( new Dimension(400,400));
        Global.s = 0;

        final JPanel pan = new JPanel();
        final JButton plus = new JButton();
        final JButton minus = new JButton();

        plus.setText("+");
        minus.setText("-");

        plus.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
//                s++;
                Global.s++;
            }
        });

        minus.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                Global.s--;
            }
        });


        fr.add(pan);
        pan.add(plus);
        pan.add(minus);

        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();

        Timer tm= new Timer(400, new ActionListener(){
            int i=0,x=100,y=100;
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Graphics2D gr=(Graphics2D)pan.getRootPane().getGraphics();
                pan.update(gr);

                GeneralPath path=new GeneralPath();

                path.append(new Ellipse2D.Double(x, y, 10, 10),true);
                gr.fillOval(x, y, 10, 10);

                //float centerX = x + (w)/2;
                //float centerY = y + (h)/2;

                AffineTransform tranforms = AffineTransform.getRotateInstance((i), x+=Global.s, y);

                gr.transform(tranforms);
                gr.draw(path);
            }
        });
        tm.start();
    }

    public static void Ten() {   //объявление публичного (общедоступного) статичного метода Ten(), который ничего не возвращает и не принимает в качестве параметра
        JFrame fr = new JFrame("Строка");  //создание экземпляра класса JFrame с именем fr и заголовком "Строка"
        String[] sourse = {"Dungeon","Ariel","Batang","Impact","Mistral"}; //создание массива строк с именем source и перечислением значений, хранящихся в нём. Значения будут использоваться в качестве имён шрифтов

        fr.setPreferredSize(new Dimension(400,400)); //установить для фрейма предпочтительный размер окна, в качестве параметра передаётся измерение (или размерность)

        final JDesktopPane pan = new JDesktopPane(); //создать экземпляр класса JDesktopPane с именем pan и вызвать его конструктор new JDesktopPane(); в конструктор никаких переменных не передаётся

        fr.add(pan); //добавить на фрейм созданную в предыдущей строке панель
        fr.setVisible(true); //сделать фрейм видимым пользователю
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //установить стандартную операцию при закрытии (EXIT_ON_CLOSE - выйти при закрытии)
        fr.pack(); //размещает добавленные во фрейм элементы сгласно предпочтительному размеру окна, заданным вызовом метода setPreferredSize() для объекта fr

        final JComboBox box = new JComboBox(sourse); //создать объект класса JComboBox с именем box и конструктором JComboBox(sourse), в который передаётся массив строк. JComboBox - выпадающее меню с выбором одной из альтернатив
        box.setBounds(250,0,100,50); //установить размерность рамки для JComboBox
        pan.add(box); //добавить box на панель элементов графического интерфейса фрейма

        Timer tm = new Timer(20, new ActionListener() { //создать объект класса Timer с именем tm для его инициализации вызывается конструктор Timer(), в который передаются параметры
            //20= 2 миллисекунды, слушатель событий ActionListener() - через заданный интервал времени (20) происходит событие, обработка которого делегируется в метод actionPerformed
            //то есть, если нужное время проходит, то программа выполняет действия
            int x = 0, h = 20, w = 100; //координаты и параметры высоты/ширины текстового поля
            String content = "Watch this!", newContent = "";  //объявление и инициализация строковых переменных для отображения текста

            @Override //переопределение стандартного метода actionPerformed
            public void actionPerformed(ActionEvent arg0) {  //в качестве параметра - экземпляр класса ActionEvent - произошедшего события
                x++; //увеличение значения координаты по оси Х

                String value = box.getSelectedItem().toString(); //в объявленную переменную value присвоить значение, которое пользователь выбрал из выпадающего меню. toString() - преобразовать его в строку

                int count = pan.getComponentCount(); //в переменную счётчика присвоить количество компонентков на панели
                if (count > 1) //если количество этих компонентов больше единицы,
                    pan.remove(1); //то удалить первый
                //логика работы такова: появляется одна строка, на смену ей - другая, изменённая. а первая в свою очередь удаляется, и так до тех пор, пока приложение не завершит свою работу
                if (x+w >= 400) { //если строчка "уехала" до края окна,
                    newContent = ""; //то обнулить строку с новым контентом
                    for (int j = 0; j < content.length(); j++){ //и в цикле, который отрабатывает до конца длины исходной строки,
                        char c = content.charAt(j); //взять элемент, номер которого соответствует индексу в цикле
                        double r = Math.random() * 10; //рассчитать произвольное значение (рандомное),
                        if(r >= 5) { //и если оно больше или равно 5, то текущий символ (соответствующий номеру индекса в строке)
                            c = Character.toLowerCase(c); //привести к нижнему регистру
                            newContent += c; //добавить этот символ к строке, которая отобразится после выхода из цикла
                        } else { //в ином случае
                            c = Character.toUpperCase(c); //привести символ к верхнему регистру (заглавная буква)
                            newContent += c; //и присоединить к строке
                        } //завершение блока "иначе"
                    } //завершение блока цикла прохождения по всем символам исходной строки
                    content = newContent; //получившуюся строку присвоить в другую строку, которая отобразится на экране
                    JLabel label = new JLabel(content); //создать для этого текстовую метку с надписью из переменной content
                    label.setBounds(x, x, w, h); //установить размеры и координаты метки
                    label.setFont(new Font(value, Font.PLAIN, 12)); //установить для текста в метке выбранный пользователем шрифт, его тип и размер
                    pan.add(label); //добавить на панель
                    x = 0; //обновить значение координаты на 0 - метка отобразится в левом верхнем углу экрана
                } else { //если координаты плавающей метки не дошли до края окна,
                    JLabel label = new JLabel(content); //создать метку
                    label.setFont(new Font(value, Font.PLAIN, 12)); //присвоить ей шрифт, тип, размер
                    label.setBounds(x, x, w, h); //установить размеры и координаты метки
                    pan.add(label); //добавить метку на панель
                } //завершение блока "иначе"
                pan.updateUI(); //обновить содержание панели - вызвав стандартный метод updateUI()
            } //конец метода actionPerformed()
        }); //конец объявления таймера
        tm.start(); //запуск таймера - вызов метода start() для объекта tm класса Timer
    } //конец 10й задачи

    public static void Twelve() { //объявление публичного (общедоступного) статичного метода Twelve(), который ничего не возвращает и не принимает в качестве параметра
        JFrame fr = new JFrame("Орбиты"); //создание экземпляра класса JFrame с именем fr и заголовком "Орбиты"
        fr.setPreferredSize( new Dimension(400, 400)); //установить для фрейма предпочтительный размер окна, в качестве параметра передаётся измерение (или размерность)
        final JPanel pan = new JPanel(); //создать экземпляр класса JPanel с именем pan и вызвать его конструктор new JPanel(); в конструктор никаких переменных не передаётся

        fr.add(pan); //добавить на фрейм созданную в предыдущей строке панель
        fr.setVisible(true); //сделать фрейм видимым пользователю
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //установить стандартную операцию при закрытии (EXIT_ON_CLOSE - выйти при закрытии)
        fr.pack(); //размещает добавленные во фрейм элементы сгласно предпочтительному размеру окна, заданным вызовом метода setPreferredSize() для объекта fr

        Timer tm = new Timer(200, new ActionListener() { //создать объект класса Timer с именем tm для его инициализации вызывается конструктор Timer(), в который передаются параметры
            //200= 20 миллисекунды, слушатель событий ActionListener() - через заданный интервал времени (200) происходит событие, обработка которого делегируется в метод actionPerformed
            //то есть, если нужное время проходит, то программа выполняет действия
            int i = 0, x = 100, y = 100, delta = 20, r = 30; //координаты и параметры, относящиеся к отрисовке объектов и маршруту следования спутника

            @Override //переопределение стандартного метода actionPerformed
            public void actionPerformed(ActionEvent arg0) { //в качестве параметра - экземпляр класса ActionEvent - произошедшего события
                Graphics2D gr = (Graphics2D)pan.getRootPane().getGraphics(); //создание переменной, отвечающей за более сложное (чем в классе Graphics) управление геометрией, координацией преобразования, управление цветом. Создаётся на основе панели pan
                pan.update(gr); //обновить панель с графической переменной

                GeneralPath path = new GeneralPath(); //создание "геометрического пути", состоящего из линий, заданных координатами
                //"геометрический путь" - это то, каким образом примитивы будут отрисовываться на панели

                if (delta > 0) { //если спутник летит в сторону правого края окна, то:
                    path.append(new Ellipse2D.Double(200,100,40,40), true); //добавить в путь контур круга (планеты), являющийся объектом Ellipse2D
                    gr.setColor(Color.red); //установить красный цвет
                    gr.fillOval(200, 100, 40, 40); //и применить этот цвет к сорежимому круга по тем же координатам центра, высоте и ширине

                    Ellipse2D follower =  new Ellipse2D.Double(x, y, r, r);  //создаётся ещё один круг - спутник, с переменнымы координатами центра

                    path.append(follower, false); //добавить в путь
                    gr.setColor(Color.black); //установить чёрный цвет
                    gr.fillOval(x, y, r, r); //и заполнить круг спутника изнутри
                } else { //если спутник летит в обратную сторону, то:
                    Ellipse2D follower =  new Ellipse2D.Double(x, y, r, r); //создать сначала его

                    path.append(follower, false); //добавить круг спутника в "графический контур"
                    gr.setColor(Color.black); //установить чёрный цвет
                    gr.fillOval(x, y, r, r); //и заполнить его изнутри чёрным

                    path.append(new Ellipse2D.Double(200,100,40,40), false); //добавить в путь созданную по заданным параметрам планету
                    gr.setColor(Color.red); //установить красный цвет
                    gr.fillOval(200, 100, 40, 40); //и заполнить круг планеты изнутри
                }//конец блока if-else, сделан, чтобы получилась иллюзия облёта спутником планеты спереди и сзади, за планетой. Реализовано за счёт очерёдности добавления фируг планеты/спутника и спутника/планеты в графический путь

                if (x+delta+r >= 400 || x <= 0)
                    delta *= -1; //то сделать дельту отрицательной, для того, что бы спутник пошёл в обратном направлении

                AffineTransform tranforms = AffineTransform.getRotateInstance((i), x += delta, y);
                gr.transform(tranforms); //применить только что созданную трансформацию к объекту графики
                gr.draw(path); //отрисовать созданные в GeneralPath графические примитивы
            } //конец метода actionPerformed()
        }); //конец объявления таймера
        tm.start(); //запуск таймера - вызов метода start() для объекта tm класса Timer
    } //конец 12й задачи
} //конец класса Main - главного класса в этом файле

//кстати, методы упражнений везде объявлены статическими, чтобы их можно было вызвать из главного метода приложения - main()
//если их не объявить статическими - из main() они будут не доступны
