package solid.d;

class ProductService{
    public void findAll(){
        step1();
        step2();
        step3();
    }
    public void step1(){};
    public void step2(){};
    public void step3(){};

}

class ProductController{
    private ProductService service;

    public void findAll(){
        // Sai
        service.step1();
        service.step2();
        service.step3();

        // Đúng
        service.findAll();
    }
}

public class dependencyInversionDemo {
    public static void main(String[] args) {
        //Dependency inversion
        // Các module giao tiếp với nhau thông qua trừu tượng (abstract/interface)
    }
}
