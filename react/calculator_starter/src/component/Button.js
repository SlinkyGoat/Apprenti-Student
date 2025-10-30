import React from "react";
import PropTypes from "prop-types";
import "./Button.css";

export default class Button extends React.Component {

    static propTypes = {
        name: PropTypes.string,
        orange: PropTypes.bool,
        wide: PropTypes.bool,
        clickHandler: PropTypes.func,
    };
  
    // javascript code goes here
    handleClick = () => {
        this.props.clickHandler(this.props.name);
    }

    render() {

        const myCssClass = [
            "component-button",
            this.props.orange ? "orange" : "",
            this.props.wide?"wide":""
        ];

        return (
            <div className={myCssClass.join(" ").trim()}>
                <button onClick={this.handleClick}>
                    {this.props.name}
                    {/* random text */}
                </button>
            </div>
        );
    }


}

Button.propTypes = {
    name: PropTypes.string.isRequired,
    clickHandler: PropTypes.func.isRequired,
};
