package lab10_.demo.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
public class Controller {

    Images images = new Images();

    @RequestMapping("/hello")
    public String sayHello(@RequestParam(value = "name") String name) {
        return "Hello " + name + "!";
    }

    @RequestMapping(value = "/image/add", method = RequestMethod.POST)
    public String addImage(HttpServletRequest requestEntity) throws Exception {
        return images.setImage(requestEntity.getInputStream());
    }

    @RequestMapping(value = "/image/{id}/gray", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getGrayImage(@PathVariable int id) throws Exception {
        return images.getGrayImage(id);
    }

    @RequestMapping(value = "/image/{id}/blur/{radius}", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getGaussImage(@PathVariable int id, @PathVariable int radius)throws Exception {
        return images.getGaussImage(id,radius);
    }

    @DeleteMapping("/image/{id}")
    public void deleteImage(@PathVariable int id)  {
        images.delete(id);
    }

    @GetMapping("/image/{id}/size")
    public String getSize(@PathVariable int id)  {
        return images.getSize(id);
    }

    @GetMapping(value = "/image/{id}/scale/{percent}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] imageScale(@PathVariable int id, @PathVariable double percent) throws IOException {
        return images.imageScale(id,percent); }

    @GetMapping("/image/{id}/histogram")
    public String getHistogram(@PathVariable int id){
        return images.getHistogram(id);
    }

    @GetMapping(value = "/image/{id}/crop/{start}/{stop}/{width}/{height}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPartOfImage(@PathVariable int id,@PathVariable int start,@PathVariable int stop,@PathVariable int width,@PathVariable int height) throws IOException {
        return images.getPartOfImage(id,start,stop,width,height);
    }
}

