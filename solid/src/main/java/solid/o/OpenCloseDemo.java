package solid.o;

class PostRepositoryV1 {
    public void findAll(){
        //...
    }
}

final class PostRepositoryV2 extends PostRepositoryV1{
    public void findById(){
        //....
    }

    @Override
    public void findAll(){
        //....
    }
}

//TH class trước có từ khóa final thì không thể kế thừa mà dùng has-a
class PostRepositoryV3{
    private PostRepositoryV2 repository;

    //Nếu muốn giữ nguyên findAll
    public void findAll(){
        repository.findAll();
    }

    //Nếu muốn thay đổi findById
    public void findById(){
        //...
    }
}

public class OpenCloseDemo {
    public static void main(String[] args) {
        // Open / Closed
        // Mở rộng mà không làm thay đổi code cũ
        PostRepositoryV2 post = new PostRepositoryV2();
        post.findAll();
        post.findById();
    }
}
