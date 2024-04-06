package service;

import jakarta.annotation.Resource;
import model.Asset;
import org.springframework.stereotype.Service;
import repository.AssetRepository;

import java.util.List;

@Service
public class AssetService {
    @Resource
    AssetRepository assetRepository;

    public List<Asset> getAllAssets(){
        return assetRepository.findAll();
    }


}
