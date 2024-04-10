package DACNPM.asset_management.controller;

import DACNPM.asset_management.model.Account;
import DACNPM.asset_management.model.Asset;
import DACNPM.asset_management.service.AssetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.List;

@Controller
public class AssetController {

    @Autowired
    AssetService assetService;

    @GetMapping("/home")
    public String getAllAsset(@SessionAttribute("loggedInAccount") Account loggedInAccount, Model model) {
        List<Asset> listAsset = assetService.getAllAssets();
        model.addAttribute("listAsset", listAsset);
        model.addAttribute("asset", new Asset());
        model.addAttribute("loggedInAccount", loggedInAccount);

        return "index";
    }
    @ResponseBody
    @GetMapping("/listAsset")
    public List<Asset> getAll(){
        return assetService.getAllAssets();
    }

    @PostMapping("/addNewAsset")
    public String addNewAsset(@ModelAttribute("asset") Asset asset) {
        assetService.addNewAsset(asset);
        return "redirect:/home";
    }

    @PostMapping("updateAsset/{id}")
    public String updateAsset(@PathVariable("id") int id, @ModelAttribute("asset") Asset asset) throws Exception {
        assetService.updateAsset(id, asset);
        return "redirect:/home";
    }

    @PostMapping("deleteAsset/{id}")
    public String deleteAsset(@PathVariable("id") int id) {
        assetService.deleteAsset(id);
        return "redirect:/home";
    }

}
