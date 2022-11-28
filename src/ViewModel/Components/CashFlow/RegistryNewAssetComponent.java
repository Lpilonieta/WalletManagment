package ViewModel.Components.CashFlow;

public class RegistryNewAssetComponent {

    private RegistryNewAssetTemplate registryNewAssetTemplate;

    private IngresosComponent ingresosComponent;

    public RegistryNewAssetComponent (IngresosComponent ingresosComponent){

        this.ingresosComponent = ingresosComponent;
        this.registryNewAssetTemplate = new RegistryNewAssetTemplate(this);

    }

    public RegistryNewAssetTemplate getRegistryNewAssetTemplate() {
        return registryNewAssetTemplate;
    }
}
