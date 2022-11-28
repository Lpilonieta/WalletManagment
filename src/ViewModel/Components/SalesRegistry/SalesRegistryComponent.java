package ViewModel.Components.SalesRegistry;

public class SalesRegistryComponent {

    private SalesRegistryTemplate salesRegistryTemplate;

    public SalesRegistryComponent(){

        this.salesRegistryTemplate = new SalesRegistryTemplate(this);

    }

    public SalesRegistryTemplate getSalesRegistryTemplate() {
        return salesRegistryTemplate;
    }
}
