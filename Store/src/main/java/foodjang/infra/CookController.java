package foodjang.infra;

import foodjang.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value="/cooks")
@Transactional
public class CookController {

    @Autowired
    CookRepository cookRepository;

    @RequestMapping(
        value = "cooks/{id}/accept-or-reject",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Cook acceptOrReject(
        @PathVariable(value = "id") Long id,
        @RequestBody AcceptOrRejectCommand acceptOrRejectCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /cook/acceptOrReject  called #####");
        Optional<Cook> optionalCook = cookRepository.findById(id);

        optionalCook.orElseThrow(() -> new Exception("No Entity Found"));
        Cook cook = optionalCook.get();
        cook.acceptOrReject(acceptOrRejectCommand);

        cookRepository.save(cook);
        return cook;
    }

    @RequestMapping(
        value = "cooks/{id}/startcook",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Cook startcook(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /cook/startcook  called #####");
        Optional<Cook> optionalCook = cookRepository.findById(id);

        optionalCook.orElseThrow(() -> new Exception("No Entity Found"));
        Cook cook = optionalCook.get();
        cook.startcook();

        cookRepository.save(cook);
        return cook;
    }

    @RequestMapping(
        value = "cooks/{id}/finishcook",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Cook finishcook(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /cook/finishcook  called #####");
        Optional<Cook> optionalCook = cookRepository.findById(id);

        optionalCook.orElseThrow(() -> new Exception("No Entity Found"));
        Cook cook = optionalCook.get();
        cook.finishcook();

        cookRepository.save(cook);
        return cook;
    }
}
