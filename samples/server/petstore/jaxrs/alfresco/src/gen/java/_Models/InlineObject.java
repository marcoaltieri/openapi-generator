package _Models;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * InlineObject
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JAXRSAlfrescoCodegen", date = "2019-02-17T22:52:35.788Z[Europe/London]")



public class InlineObject   {
  @JsonProperty("name")
  private String name;

  @JsonProperty("status")
  private String status;

  public InlineObject name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Updated name of the pet
   * @return name
  */
  @ApiModelProperty(value = "Updated name of the pet")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public InlineObject status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Updated status of the pet
   * @return status
  */
  @ApiModelProperty(value = "Updated status of the pet")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineObject inlineObject = (InlineObject) o;
    return Objects.equals(this.name, inlineObject.name) &&
        Objects.equals(this.status, inlineObject.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineObject {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

