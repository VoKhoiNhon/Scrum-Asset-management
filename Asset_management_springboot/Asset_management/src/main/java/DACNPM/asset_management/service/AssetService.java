package DACNPM.asset_management.service;

import jakarta.annotation.Resource;
import DACNPM.asset_management.model.Asset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Service;
import DACNPM.asset_management.repository.AssetRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AssetService {
    @Autowired
    AssetRepository assetRepository;

    public List<Asset> getAllAssets(){
        return assetRepository.findAll();
    }
    public Asset addNewAsset(Asset asset){
        return assetRepository.save(asset);
    }

    public void updateAsset(int id,Asset updatedAsset) throws Exception {
        Optional<Asset> optionalAsset = assetRepository.findById(id);
        if (optionalAsset.isPresent()) {
            Asset asset = optionalAsset.get();
            // Cập nhật thông tin của tài sản với dữ liệu từ updatedAsset
            asset.setAssetName(updatedAsset.getAssetName());
            asset.setStatus(updatedAsset.getStatus());
            asset.setPurchasePrice(updatedAsset.getPurchasePrice());
            asset.setDatePurchase(updatedAsset.getDatePurchase());
            asset.setDescription(updatedAsset.getDescription());
            // Lưu thay đổi vào cơ sở dữ liệu
            assetRepository.save(asset);
        } else {
            // Xử lý trường hợp không tìm thấy tài sản với ID đã cung cấp
            throw new Exception("Asset with id " + id + " not found");
        }
    }

    public void deleteAsset(int id){
        assetRepository.deleteById(id);
    }


}
