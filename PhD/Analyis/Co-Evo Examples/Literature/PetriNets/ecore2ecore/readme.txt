This folder contains the files necessary for performing migration with EMF's Ecore2Ecore mapping.

The method used was described by Marcelo Paternostro and Kenn Hussey in an EclipseCon 2006 presentation (included in the doc folder), and in the EMF Recipes wiki page: http://wiki.eclipse.org/EMF/Recipes#Recipe:_Data_Migration

To use the files:

1) Create a new Java project called petrinets.
2) Copy the model into the petrinets project.
3) Use the After.genmodel file to generate the EMF model, edit and editor source code.
4) Create a new package lit_petriNets.resources, in petrinets/src.
5) Copy the PetriNetsFactoryImpl.java and PetriNetsResourceHandler.java to the lit_petriNets.resources package.
6) Add the extension_parser extension from plugin.xml to the petrinets/plugin.xml:

<extension point="org.eclipse.emf.ecore.extension_parser">
  <parser class="lit_petriNets.resources.PetriNetsFactoryImpl" type="lit_petrinets"/>
</extension>


When an instance of Before.ecore is loaded, the Ecore2Ecore mapping is used to determine for each model element the EClass to which it will be bound. PetriNetsResourceHandler is used to migrate model values that aren't recognised by the default deserialisation mechanism (which expects to find only those model values permitted by the features of After.ecore). 